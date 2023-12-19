package com.example.demoassignment.Responsitory;

import com.example.demoassignment.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserResponsitory extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
