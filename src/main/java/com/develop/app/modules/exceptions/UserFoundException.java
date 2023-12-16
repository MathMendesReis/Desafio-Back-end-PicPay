package com.develop.app.modules.exceptions;

public class UserFoundException extends RuntimeException{
  public UserFoundException(){
    super("usuario ja existe");
  }
}
