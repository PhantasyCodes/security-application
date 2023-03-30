package com.playstr.security.auth;

import com.playstr.security.config.JwtService;
import com.playstr.security.user.Role;
import com.playstr.security.user.User;
import com.playstr.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(String firstName, String lastName, String email, String password, MultipartFile profilePic) {
        byte[] bytes = null;
        try {
            bytes = profilePic.getBytes();
        } catch (IOException e) {
            ;
        }
        var user = User.builder()
                .firstname(firstName)
                .lastname(lastName)
                .email(email)
                .profilePic(bytes)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).firstname(user.getFirstname()).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).firstname(user.getFirstname()).profilePic(user.getProfilePic()).build();
    }
}
