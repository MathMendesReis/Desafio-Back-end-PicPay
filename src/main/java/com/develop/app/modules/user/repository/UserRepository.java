package com.develop.app.modules.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develop.app.modules.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
  Optional <UserEntity> findByEmail( String email);
  Optional <UserEntity> findByCpf( String cpf);
  Optional <UserEntity> findAllById(UUID sendId);
}
