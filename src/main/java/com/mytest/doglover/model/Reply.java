package com.mytest.doglover.model;

import com.mytest.doglover.model.user.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Reply extends BaseTimeEntity {

  @Id
  @GeneratedValue
  @Column(name = "REPLY_NO")
  private Long id;

  private String content;

  @JoinColumn(name = "USER_NO")
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private User user;

  @JoinColumn(name = "BOARD_NO")
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Board board;
}
