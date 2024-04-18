package com.application.chat.gestionuser.domain.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.application.chat.gestionuser.domain.dto.ResponseFriendsDto;
import com.application.chat.gestionuser.domain.repository.FriendRepository;
import com.application.chat.gestionuser.domain.service.FriendService;
import com.application.chat.gestionuser.util.interfaces.IFriends;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FriendImp implements FriendService {

    private final FriendRepository friendRepository;

    @Override
    public ResponseEntity<ResponseFriendsDto> friendUsers(Long id) {
        List<IFriends> lstFriends = friendRepository.findFriendsById(id);
        HttpStatus statusResponse = !lstFriends.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        var body = ResponseFriendsDto.builder()
                .status(statusResponse.toString())
                .message("Lista de amigos")
                .lstFriends(lstFriends).build();
        return new ResponseEntity<>(body, statusResponse);
    }
}
