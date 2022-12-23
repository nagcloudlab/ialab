package com.example.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.exceptions.UserExistException;
import com.example.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null)
            throw new UserExistException("Username already exists");
        List<Role> roles = List.of(
                new Role(1L), new Role(2L), new Role(3L));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        Collection<GrantedAuthority> authorities=user
                .getRoles()
                .stream().
                map(role->new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
        return userDetails;
    }



}
