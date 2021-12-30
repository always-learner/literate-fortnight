package com.mycakeapp.controllers;

import com.mycakeapp.entities.User;
import com.mycakeapp.entities.UserDto;
import lombok.extern.slf4j.Slf4j;
import com.mycakeapp.entities.ResponseDto;
import com.mycakeapp.exceptions.UserNotFoundException;
import com.mycakeapp.requests.LoginRequest;
import com.mycakeapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/v1.0/user")
@CrossOrigin
public class UserController {

    private UserService userService = new UserService();

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<ResponseDto> login(@Valid @RequestBody LoginRequest loginRequest) throws IOException {
        try {
            log.info("request_body: {}", loginRequest.toString());

            HttpHeaders headers = new HttpHeaders();

            UserDto userDto = new UserDto();
            userDto.setEmail(loginRequest.getEmail());
            userDto.setPassword(loginRequest.getPassword());

            userDto = userService.getUser(userDto);

            return ResponseEntity.ok().headers(headers).body(new ResponseDto("200", "200", userDto));
        }
        catch (Exception e) {
            return ResponseEntity.ok().body(new ResponseDto("204", e.getMessage(), null));
        }
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(new ResponseDto("200", "200", user1));
    }
}
