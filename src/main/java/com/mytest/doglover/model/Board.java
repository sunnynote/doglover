package com.mytest.doglover.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Board extends BaseTimeEntity  {

  @Id
  @GeneratedValue
  @Column(name = "BOARD_NO")
  private Long id;

  private String title;

  private String content;

  @JoinColumn(name = "BOARDMAP_NO")
  @ManyToOne(fetch = FetchType.LAZY)
  private Boardmap boardmap;
}
