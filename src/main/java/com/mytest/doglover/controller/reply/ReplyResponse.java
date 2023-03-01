package com.mytest.doglover.controller.reply;

import com.mytest.doglover.model.Reply;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(value = "RES: 댓글 작성 후 받는 정보")
@Getter
public class ReplyResponse {

  @ApiModelProperty(value = "댓글 번호", required = true)
  private Long replyId;

  @ApiModelProperty(value = "댓글 내용", required = true)
  private String content;

  @ApiModelProperty(value = "닉네임", required = true)
  private String nickname;

  public ReplyResponse(Reply reply){
    replyId = reply.getId();
    content = reply.getContent();
//    nickname = reply.getBoard().getBoardmap().getUser().getNickname();
    nickname = reply.getUser().getNickname();
  }
}
