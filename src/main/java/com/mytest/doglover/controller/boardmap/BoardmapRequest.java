package com.mytest.doglover.controller.boardmap;

import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.model.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(value = "REQ: 게시판 생성 시 필요한 정보")
@Getter
public class BoardmapRequest {

  @ApiModelProperty(value = "게시판 제목", required = true)
  private String title;

  public Boardmap newBoardmap(User user, String title){
    return new Boardmap(user, title);
  }
}
