package com.mytest.doglover.controller.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(value = "RES: 로그인 후 받는 정보")
@Getter
public class LoginResponse {
  @ApiModelProperty(value = "로그인 성공시 받는 토큰")
  private String token;
  @ApiModelProperty(value = "로그인 한 사용자 닉네임")
  private String nickname;

  public LoginResponse(String token, String nickname) {
    this.token = token;
    this.nickname = nickname;
  }
}
