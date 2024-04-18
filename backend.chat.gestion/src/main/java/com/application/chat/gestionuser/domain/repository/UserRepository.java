package com.application.chat.gestionuser.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.chat.gestionuser.persistence.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
