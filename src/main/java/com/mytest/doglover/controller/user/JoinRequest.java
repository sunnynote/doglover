package com.mytest.doglover.controller.user;

import com.mytest.doglover.model.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "REQ: 가입 시 필요한 정보")
public class JoinRequest {

  @ApiModelProperty(value = "이메일", required = true)
  private String email;
  @ApiModelProperty(value = "비밀번호", required = true)
  private String password;
  @ApiModelProperty(value = "닉네임", required = true)
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
