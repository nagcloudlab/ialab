package com.example;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class TodosServiceApplication {

    private final UserRepository userRepository;
    public TodosServiceApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodosServiceApplication.class, args);
    }


//    @EventListener(ApplicationStartedEvent.class)
    public void initDb(){
        User nagUser=new User();
        nagUser.setEmail("nag@gmail.com");
        nagUser.setPassword("12345678");
        nagUser.setName("Nag");
        nagUser.setRoles(List.of(new Role("TRAINER")));

        User rahulUser=new User();
        rahulUser.setEmail("rahul@gmail.com");
        rahulUser.setPassword("12345678");
        rahulUser.setName("Rahul");
        rahulUser.setRoles(List.of(new Role("TRAINER"),new Role("MANAGER")));
        userRepository.save(nagUser);
        userRepository.save(rahulUser);
    }

}
