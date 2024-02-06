package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.paginate.PaginateUsersResponseDto;
import com.eadp.userserviceapi.dto.request.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;

public interface UserService {
    PaginateUsersResponseDto findAllUsers(int page, int size, String searchText);

    void createUser(RequestUserDto dto);

    ResponseUserDto findUser(String userId);

    void updateUser(String userId, RequestUserDto dto);

    void deleteUser(String userId);
}
