package com.eadp.userserviceapi.repository;

import com.eadp.userserviceapi.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE property_id=?1")
    public Optional<User> findUserByUserId(int id);

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE full_name LIKE ?1 OR email LIKE ?1")
    List<User> findAllUsers(String searchText, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM user WHERE full_name LIKE ?1 OR email LIKE ?1")
    Long findAllUserCount(String searchText);
}