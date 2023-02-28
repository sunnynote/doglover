package com.mytest.doglover.controller.reply;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Reply;
import com.mytest.doglover.model.user.User;
import lombok.Getter;

@Getter
public class ReplyRequest {
  private String content;

  public Reply newReply(Board board, User user, String content){
    return new Reply(board, user, content);
  }
}
