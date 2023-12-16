package com.develop.app.modules.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develop.app.modules.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
  
}
