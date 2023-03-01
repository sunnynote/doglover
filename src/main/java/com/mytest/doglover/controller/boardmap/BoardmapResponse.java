package com.mytest.doglover.controller.boardmap;

import com.mytest.doglover.model.Boardmap;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@ApiModel(value = "RES: 게시판 생성 후 받는 정보")
@Getter
public class BoardmapResponse {

  @ApiModelProperty(value = "게게판 번호")
  private Long boardmapId;

  @ApiModelProperty(value = "게시판 제목")
  private String title;

  @ApiModelProperty(value = "닉네임")
  private String nickname;

  @ApiModelProperty(value = "수정 시간")
  private LocalDateTime modifiedDate;

  public BoardmapResponse(Boardmap boardmap){
    boardmapId = boardmap.getId();
    title = boardmap.getTitle();
    nickname = boardmap.getUser().getNickname();
    modifiedDate = boardmap.getModifiedDate();
  }
}
