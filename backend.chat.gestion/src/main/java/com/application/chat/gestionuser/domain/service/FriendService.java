package com.application.chat.gestionuser.domain.service;

import org.springframework.http.ResponseEntity;

import com.application.chat.gestionuser.domain.dto.ResponseFriendsDto;

public interface FriendService {
    
    ResponseEntity<ResponseFriendsDto> friendUsers(Long id);
}
