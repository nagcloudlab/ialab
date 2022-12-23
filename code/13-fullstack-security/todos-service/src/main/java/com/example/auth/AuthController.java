package com.example.auth;

import com.example.api.HttpError;
import com.example.jwt.JwtTokenProvider;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
//
    @PostMapping("/login")
    public ResponseEntity<?> auth(
            @RequestBody AuthRequest request
    ) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            HttpError httpError = new HttpError();
            httpError.setCode(HttpStatus.UNAUTHORIZED);
            httpError.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(httpError);
        }
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        String jwtToken = jwtTokenProvider.generateToken(userDetails);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccessToken(jwtToken);
        return ResponseEntity.status(HttpStatus.OK).body(authResponse);
    }


}
