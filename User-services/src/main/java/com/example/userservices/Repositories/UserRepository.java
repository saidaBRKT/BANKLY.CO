package com.example.userservices.Repositories;

import com.example.userservices.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByEmail(String email);

    User findUserById(Long userId);
    User findByCin(String cin);

    User findByEmail(String email);
}
