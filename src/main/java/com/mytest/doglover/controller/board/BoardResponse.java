package com.mytest.doglover.controller.board;

import com.mytest.doglover.model.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {

  private Long boardId;

  private String title;

  private String content;

  private Long userId;

  private String nickname;

  private LocalDateTime createDate;
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
