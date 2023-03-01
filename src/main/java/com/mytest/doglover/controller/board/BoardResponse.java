package com.mytest.doglover.controller.board;

import com.mytest.doglover.model.Board;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@ApiModel(value = "RES: 게시물 작성 후 받는 정보")
@Getter
public class BoardResponse {

  @ApiModelProperty(value = "게시물 번호")
  private Long boardId;

  @ApiModelProperty(value = "게시물 제목")
  private String title;

  @ApiModelProperty(value = "게시물 내용")
  private String content;

  @ApiModelProperty(value = "회원 번호")
  private Long userId;

  @ApiModelProperty(value = "닉네임")
  private String nickname;

  @ApiModelProperty(value = "작성 시간")
  private LocalDateTime createDate;

  @ApiModelProperty(value = "수정 시간")
  private LocalDateTime modifiedDate;

  public BoardResponse(Board board){
    userId = board.getBoardmap().getUser().getId();
    boardId = board.getId();
    title = board.getTitle();
    content = board.getContent();
    nickname = board.getBoardmap().getUser().getNickname();
    createDate = board.getCreatedDate();
    modifiedDate = board.getModifiedDate();
  }
}
