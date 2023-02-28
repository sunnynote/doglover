package com.mytest.doglover.model;

import com.mytest.doglover.model.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Board extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BOARD_NO")
  private Long id;

  private String title;

  private String content;

  @JoinColumn(name = "BOARDMAP_NO")
  @ManyToOne(fetch = FetchType.LAZY)
  private Boardmap boardmap;

  public Board() {}

  @Builder
  public Board(Boardmap boardmap, String title, String content){
    this.boardmap = boardmap;
    this.title = title;
    this.content = content;
  }

  public void update(String title, String content){
    this.title = title;
    this.content = content;
  }
}
