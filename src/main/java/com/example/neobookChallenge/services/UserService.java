package com.example.neobookChallenge.services;

import com.example.neobookChallenge.models.User;
import com.example.neobookChallenge.repositories.UserRepository;
import com.example.neobookChallenge.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse registerUser(String userName) {

            User newUser = userRepository.save(new User(userName));

            return new UserResponse(newUser.getId(), newUser.getName());
    }
}
