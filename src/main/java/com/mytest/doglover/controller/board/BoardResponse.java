package com.mytest.doglover.controller.board;

import com.mytest.doglover.model.Board;
import lombok.Getter;

@Getter
public class BoardResponse {
  private Long boardId;

  private String title;

  private String content;

  private String nickname;

  public BoardResponse(Board board){
    boardId = board.getId();
    title = board.getTitle();
    content = board.getContent();
    nickname = board.getBoardmap().getUser().getNickname();
  }
}
