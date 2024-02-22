package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.paginate.UsersPaginateResponseDto;
import com.eadp.userserviceapi.dto.request.UserRequestDto;
import com.eadp.userserviceapi.dto.response.UserResponseDto;

public interface UserService {
    UsersPaginateResponseDto findAllUsers(int page, int size, String searchText);

    void createUser(UserRequestDto dto);

    UserResponseDto findUser(int userId);

    void updateUser(int userId, UserRequestDto dto);

    void deleteUser(int userId);
}
