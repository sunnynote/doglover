package com.mytest.doglover.controller.board;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Boardmap;
import lombok.Getter;

@Getter
public class BoardRequest {
  private String title;
  private String content;

  public Board newBoard(Boardmap boardmap, String title, String content){
    return new Board(boardmap, title, content);
  }

}
