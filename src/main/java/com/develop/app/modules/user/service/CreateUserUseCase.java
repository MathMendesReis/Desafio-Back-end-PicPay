package com.develop.app.modules.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.app.modules.exceptions.UserFoundException;
import com.develop.app.modules.user.UserEntity;
import com.develop.app.modules.user.repository.UserRepository;

@Service
public class CreateUserUseCase {

  @Autowired
  private UserRepository userRepository;

  public UserEntity execute(UserEntity userEntity){
    this.userRepository.findByEmail(userEntity.getEmail())
    .ifPresent(user -> {
      throw new UserFoundException();
    });;

    this.userRepository.findByCpf(userEntity.getCpf())
    .ifPresent(user -> {
        throw new UserFoundException();
    });
    ;

   
    return userRepository.save(userEntity);
  }
  
}
