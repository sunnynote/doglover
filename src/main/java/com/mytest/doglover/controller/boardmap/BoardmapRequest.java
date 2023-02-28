package com.mytest.doglover.controller.boardmap;

import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.model.user.User;
import lombok.Getter;

@Getter
public class BoardmapRequest {
  private String title;

  public Boardmap newBoardmap(User user, String title){
    return new Boardmap(user, title);
  }
}
