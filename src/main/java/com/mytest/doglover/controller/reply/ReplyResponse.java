package com.mytest.doglover.controller.reply;

import com.mytest.doglover.model.Reply;
import lombok.Getter;

@Getter
public class ReplyResponse {
  private Long replyId;

  private String content;

  private String nickname;

  public ReplyResponse(Reply reply){
    replyId = reply.getId();
    content = reply.getContent();
//    nickname = reply.getBoard().getBoardmap().getUser().getNickname();
    nickname = reply.getUser().getNickname();
  }
}
