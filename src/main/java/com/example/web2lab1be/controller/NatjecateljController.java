package com.example.web2lab1be.controller;

import com.example.web2lab1be.JWTDecoder;
import com.example.web2lab1be.requests.SignUpRequestBody;
import com.example.web2lab1be.services.NatjecateljService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8081/")
@RequestMapping("user")
public class NatjecateljController {

    @Autowired
    NatjecateljService service;

    @PostMapping("signin")
    public ResponseEntity<?> signIn(@RequestParam String token) {
        SignUpRequestBody signUpRequest = JWTDecoder.decodeJWT(token);
        System.out.println(signUpRequest.getFirstName() + " " + signUpRequest.getLastName() + " " + signUpRequest.getEmail() + " " + signUpRequest.getPassword());
        Integer id = service.loginUser(signUpRequest.getEmail(), signUpRequest.getPassword());
        if (id != 0) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else if (service.createUser(signUpRequest)) {
            return new ResponseEntity<>("User successfully created.", HttpStatus.OK);
        } else return new ResponseEntity<>("lose", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequestBody signUpRequest) {
        if (service.createUser(signUpRequest)) {
            return new ResponseEntity<>("User successfully created.", HttpStatus.OK);
        } else return new ResponseEntity<>("lose", HttpStatus.BAD_REQUEST);
    }
}