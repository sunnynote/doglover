package com.mytest.doglover.controller.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "REQ: 로그인 시 필요한 정보")
public class LoginRequest {

  @ApiModelProperty(value = "이메일", required = true)
  private String email;

  @ApiModelProperty(value = "비밀번호", required = true)
  private String password;

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
