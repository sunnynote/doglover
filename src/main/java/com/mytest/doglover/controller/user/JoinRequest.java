package com.mytest.doglover.controller.user;

import com.mytest.doglover.model.user.User;

public class JoinRequest {

  private String email;
  private String password;
  private String nickname;

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getNickname() {
    return nickname;
  }

  public User newUser(String email, String password, String nickname) {
    return new User(email, password, nickname);
  }
}
