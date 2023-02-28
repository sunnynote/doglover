package com.mytest.doglover.model;

import com.mytest.doglover.model.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Reply extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "REPLY_NO")
  private Long id;

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
