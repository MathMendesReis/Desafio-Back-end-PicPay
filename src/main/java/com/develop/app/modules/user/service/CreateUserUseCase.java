package com.develop.app.modules.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.app.modules.user.UserEntity;
import com.develop.app.modules.user.repository.UserRepository;

@Service
public class CreateUserUseCase {

  @Autowired
  private UserRepository userRepository;

  public UserEntity execute(UserEntity userEntity){
    return userRepository.save(userEntity);
  }
  
}
