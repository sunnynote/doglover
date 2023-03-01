package com.mytest.doglover.controller.board;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Boardmap;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(value = "REQ: 게시물 작성 시 필요한 정보")
@Getter
public class BoardRequest {

  @ApiModelProperty(value = "게시물 제목", required = true)
  private String title;

  @ApiModelProperty(value = "게시물 내용", required = true)
  private String content;

  public Board newBoard(Boardmap boardmap, String title, String content){
    return new Board(boardmap, title, content);
  }
}
