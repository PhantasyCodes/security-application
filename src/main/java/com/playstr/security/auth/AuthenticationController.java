package com.playstr.security.auth;

import com.playstr.security.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final JwtService jwtService;

    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = { "multipart/form-data", "Content-Type" })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AuthenticationResponse> register(@RequestParam("firstName") String firstName,
                                                           @RequestParam("lastName") String lastName,
                                                           @RequestParam("email") String email,
                                                           @RequestParam("password") String password,
                                                           @RequestParam("profilePic") MultipartFile profilePic) {
        return ResponseEntity.ok(service.register(firstName, lastName, email, password, profilePic));
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
