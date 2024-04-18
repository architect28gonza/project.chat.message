package com.application.chat.gestionuser.domain.dto;

import java.util.List;
import com.application.chat.gestionuser.util.interfaces.IFriends;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseFriendsDto {
    private String status;
    private String message;
    private List<IFriends> lstFriends;
}
