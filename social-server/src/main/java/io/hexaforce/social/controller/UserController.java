package io.hexaforce.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hexaforce.social.exception.ResourceNotFoundException;
import io.hexaforce.social.model.User;
import io.hexaforce.social.repository.UserRepository;
import io.hexaforce.social.security.CurrentUser;
import io.hexaforce.social.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId()).orElseThrow(() 
                -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

}
