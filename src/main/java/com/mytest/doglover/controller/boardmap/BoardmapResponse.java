package com.mytest.doglover.controller.boardmap;

import com.mytest.doglover.model.Boardmap;
import lombok.Getter;

@Getter
public class BoardmapResponse {

  private Long boardmapId;

  private String title;

  private String nickname;

  public BoardmapResponse(Boardmap boardmap){
    boardmapId = boardmap.getId();
    title = boardmap.getTitle();
    nickname = boardmap.getUser().getNickname();
  }
}
