package com.example.neobookChallenge.api;

import com.example.neobookChallenge.models.User;
import com.example.neobookChallenge.requests.UserRequest;
import com.example.neobookChallenge.responses.Response;
import com.example.neobookChallenge.responses.UserResponse;
import com.example.neobookChallenge.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", originPatterns = "*", maxAge = 5000, exposedHeaders = "Access-Control-Allow-Origin", allowedHeaders = "*")
@Tag(name = "User Api", description = "User endpoints")
public class UserApi {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Register User", description = "This method registers a user")
    UserResponse registerUser(@RequestParam String userName) {

        return userService.registerUser(userName);
    }

//    @GetMapping
//    @Operation(summary = "Login User", description = "This method allows the user login")
//    Response login(@RequestParam String userName) {
//
//        return userService.login(userName);
//    }
}
