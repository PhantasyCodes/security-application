package com.playstr.security.auth;

import com.playstr.security.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/check")
    public ResponseEntity<Boolean> check(@RequestBody JwtRequest jwtRequest) {
        return ResponseEntity.ok(jwtService.isTokenExpired(jwtRequest.getToken()));
    }

}
