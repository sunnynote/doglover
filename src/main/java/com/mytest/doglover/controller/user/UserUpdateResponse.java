package com.mytest.doglover.controller.user;

import lombok.Getter;

@Getter
public class UserUpdateResponse {
  private String email;
  private String nickname;

  public UserUpdateResponse(String email, String nickname){
    this.email = email;
    this.nickname = nickname;
  }
}
