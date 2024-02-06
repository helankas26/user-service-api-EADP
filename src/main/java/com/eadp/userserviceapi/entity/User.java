package com.eadp.userserviceapi.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Long propertyId;
    private String userId;
    private String fullName;
    private String email;
    private String avatarUrl;
    private boolean status;
}
