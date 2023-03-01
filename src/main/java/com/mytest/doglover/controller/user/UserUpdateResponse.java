package com.mytest.doglover.controller.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(value = "RES: 정보 수정 시 받는 정보")
@Getter
public class UserUpdateResponse {

  @ApiModelProperty(value = "이메일")
  private String email;

  @ApiModelProperty(value = "닉네임")
  private String nickname;

  public UserUpdateResponse(String email, String nickname){
    this.email = email;
    this.nickname = nickname;
  }
}
