package com.application.chat.gestionuser.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.chat.gestionuser.domain.dto.ResponseFriendsDto;
import com.application.chat.gestionuser.domain.dto.ResponseGestionDto;
import com.application.chat.gestionuser.domain.dto.UserGestionDto;
import com.application.chat.gestionuser.domain.service.FriendService;
import com.application.chat.gestionuser.domain.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final FriendService friendService;

    @PostMapping(value = "user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseGestionDto> registerUserChat(@RequestBody UserGestionDto user) {
        return userService.addUser(user);
    }

    @GetMapping(value = "friends/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseFriendsDto> friendsUser(@PathVariable("id") Long id) {
        return friendService.friendUsers(id);
    }
}
