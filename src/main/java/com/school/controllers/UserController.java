package com.school.controllers;
import com.school.entities.User;
import com.school.servicesImps.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserServiceImp userService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        if (userService.findByUserName(user.getUsername()).isPresent())
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("UserName " + user.getUsername() + " user already existed ");
        else
            userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("a user " +user.getUsername()+" is created");
    }
}
