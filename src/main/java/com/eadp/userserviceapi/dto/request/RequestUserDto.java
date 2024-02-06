package com.eadp.userserviceapi.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestUserDto {
    private String fullName;
    private String email;
    private String avatarUrl;
    private String password;
    private boolean status;
}
