package com.mytest.doglover.controller.boardmap;

import com.mytest.doglover.model.Boardmap;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardmapResponse {

  private Long boardmapId;

  private String title;

  private String nickname;

  private LocalDateTime modifiedDate;

  public BoardmapResponse(Boardmap boardmap){
    boardmapId = boardmap.getId();
    title = boardmap.getTitle();
    nickname = boardmap.getUser().getNickname();
    modifiedDate = boardmap.getModifiedDate();
  }
}
