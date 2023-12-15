package com.develop.app.modules.users.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develop.app.modules.users.entity.Users;

public interface UsersRepository extends JpaRepository<Users,UUID> {
  
}
