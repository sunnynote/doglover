package com.mytest.doglover.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Boardmap extends  BaseTimeEntity{

  @Id
  @GeneratedValue
  @Column(name = "BOARDMAP_NO")
  private Long id;

  private String title;

  @JoinColumn(name = "USER_NO")
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private User user;

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
  private List<Board> boards = new ArrayList<>();
}
