package com.example.gatewayservice.Repositories;

import com.example.gatewayservice.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByEmail(String email);
}
