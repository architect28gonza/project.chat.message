package com.application.login.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.login.persistence.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>  {
    
    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByIdAndUsername(Long id, String username);
}
