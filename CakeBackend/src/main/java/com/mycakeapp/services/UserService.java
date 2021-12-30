package com.mycakeapp.services;

import com.mycakeapp.entities.User;
import com.mycakeapp.entities.UserDto;
import com.mycakeapp.exceptions.UserNotFoundException;
import com.mycakeapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    //@Autowired
    //private UserRepository userRepository;

    Map<String, User> users = new HashMap<>();

    public UserDto getUser(UserDto userDto) throws IOException {

        User user = users.get(userDto.getEmail());

        if(user == null || !user.getPassword().equals(userDto.getPassword())) {
            throw new UserNotFoundException("User Not Found");
        }

        userDto.setToken(user.getToken());
        userDto.setName(user.getName());
        userDto.setId(user.getId());

        return userDto;
    }

    public User saveUser(User user){
        if (users.get(user.getEmail()) == null) {
            return users.put(user.getEmail(), user);
        } else {
            throw new UserNotFoundException("Email is already exists.");
        }
    }
}
