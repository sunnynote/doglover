package com.mytest.doglover.model;

import com.mytest.doglover.model.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@ApiModel(value = "MODEL: Reply")
@Entity
@Getter
public class Reply extends BaseTimeEntity {

  @ApiModelProperty(value = "댓글 번호")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "REPLY_NO")
  private Long id;

  @ApiModelProperty(value = "댓글 내용", required = true)
  private String content;

  @JoinColumn(name = "USER_NO")
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @JoinColumn(name = "BOARD_NO")
  @ManyToOne(fetch = FetchType.LAZY)
  private Board board;

  public Reply() {}

  @Builder
  public Reply(Board board, User user, String content){
    this.board = board;
    this.user = user;
    this.content = content;
  }
}
