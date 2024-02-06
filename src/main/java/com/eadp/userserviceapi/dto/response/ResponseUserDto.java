package com.eadp.userserviceapi.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseUserDto {
    private String id;
    private String fullName;
    private String email;
    private String avatarUrl;
    private boolean status;
}
