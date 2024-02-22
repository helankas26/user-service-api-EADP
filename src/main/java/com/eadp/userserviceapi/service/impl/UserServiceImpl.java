package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.paginate.UsersPaginateResponseDto;
import com.eadp.userserviceapi.dto.request.UserRequestDto;
import com.eadp.userserviceapi.dto.response.UserResponseDto;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repository.UserRepository;
import com.eadp.userserviceapi.service.UserService;
import com.eadp.userserviceapi.util.KeyManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KeyManager keyManager;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, KeyManager keyManager) {
        this.userRepository = userRepository;
        this.keyManager = keyManager;
    }

    @Override
    public UsersPaginateResponseDto findAllUsers(int page, int size, String searchText) {
        searchText = "%" + searchText + "%";

        List<User> allUsers = userRepository.findAllUsers(searchText, PageRequest.of(page, size));
        Long count = userRepository.findAllUserCount(searchText);

        List<UserResponseDto> dtos = new ArrayList<>();
        allUsers.forEach(e -> {
            dtos.add(new UserResponseDto(
                    e.getUserId(),
                    e.getFullName(),
                    e.getEmail(),
                    new String(e.getAvatarUrl()),
                    e.isStatus()
            ));
        });
        return new UsersPaginateResponseDto(count, dtos);
    }

    @Override
    public void createUser(UserRequestDto dto) {
        User user = new User();

        user.setUserId(keyManager.generateKey(new Random().nextInt(15)));
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setAvatarUrl(dto.getAvatarUrl().getBytes());
        user.setStatus(true);

        userRepository.save(user);
    }

    @Override
    public UserResponseDto findUser(int userId) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);

        if (selectedUser.isEmpty()) throw new RuntimeException();

        // String avatar=new String(selectedUser.get().getAvatarUrl(), StandardCharsets.UTF_8);
        return new UserResponseDto(
                selectedUser.get().getUserId(),
                selectedUser.get().getFullName(),
                selectedUser.get().getEmail(),
                new String(selectedUser.get().getAvatarUrl()),
                selectedUser.get().isStatus()
        );
    }

    @Override
    public void updateUser(int userId, UserRequestDto dto) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);

        if (selectedUser.isEmpty()) throw new RuntimeException();

        selectedUser.get().setEmail(dto.getEmail());
        selectedUser.get().setFullName(dto.getFullName());
        selectedUser.get().setAvatarUrl(dto.getAvatarUrl().getBytes());
        selectedUser.get().setStatus(dto.isStatus());

        userRepository.save(selectedUser.get());
    }

    @Override
    public void deleteUser(int userId) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);

        if (selectedUser.isEmpty()) throw new RuntimeException();

        userRepository.delete(selectedUser.get());
    }
}
