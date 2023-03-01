package com.mytest.doglover.controller.reply;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Reply;
import com.mytest.doglover.model.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(value = "REQ: 댓글 작성 시 필요한 정보")
@Getter
public class ReplyRequest {

  @ApiModelProperty(value = "댓글 내용", required = true)
  private String content;

  public Reply newReply(Board board, User user, String content){
    return new Reply(board, user, content);
  }
}
