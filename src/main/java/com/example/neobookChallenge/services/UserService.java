package com.example.neobookChallenge.services;

import com.example.neobookChallenge.models.User;
import com.example.neobookChallenge.repositories.UserRepository;
import com.example.neobookChallenge.requests.UserRequest;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean userExists(String name) {
        return userRepository.findByName(name) != null;
    }

    public Response registerUser(String userName) {

        if (!userExists(userName)) {

            User newUser = new User(userName);

            System.out.println("new user is " + newUser.getName());

            userRepository.save(newUser);

            return new Response("The user registered") ;
        }
        else return new Response("The user with this name already exists try another name");

    }

    public Response login(String userName) {

        if (userExists(userName))

            return new Response("Login successful");

        else return new Response("Invalid username");
    }
}
