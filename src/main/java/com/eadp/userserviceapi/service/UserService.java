package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.paginate.PaginateUsersResponseDto;
import com.eadp.userserviceapi.dto.request.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;

public interface UserService {
    public PaginateUsersResponseDto findAllUsers(int page, int size, String searchText);

    public void createUser(RequestUserDto dto);

    public ResponseUserDto findUser(String id);

    public void updateUser(String id, RequestUserDto dto);

    public void deleteUser(String userId);
}
