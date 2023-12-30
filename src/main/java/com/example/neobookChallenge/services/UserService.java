package com.example.neobookChallenge.services;

import com.example.neobookChallenge.models.User;
import com.example.neobookChallenge.repositories.UserRepository;
import com.example.neobookChallenge.requests.UserRequest;
import com.example.neobookChallenge.responses.Response;
import com.example.neobookChallenge.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    public boolean userExists(String name) {
//        return userRepository.findByName(name) != null;
//    }

    public UserResponse registerUser(String userName) {

//        if (!userExists(userName)) {

            User newUser = userRepository.save(new User(userName));

            return new UserResponse(newUser.getId(), newUser.getName());
//        }

    }

//    public Response login(String userName) {
//
//        if (userExists(userName))
//
//            return new Response("Login successful");
//
//        else return new Response("Invalid username");
//    }


}
