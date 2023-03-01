package com.mytest.doglover.controller.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(value = "REQ: 회원 정보 수정 시 필요한 정보")

@Getter
public class UserUpdateRequest {

  @ApiModelProperty(value = "닉네임", required = true)
  private String nickname;
}