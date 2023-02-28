package com.mytest.doglover.model;

import com.mytest.doglover.model.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Boardmap extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BOARDMAP_NO")
  private Long id;

  private String title;

  @JoinColumn(name = "USER_NO")
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @OneToMany(mappedBy = "boardmap")
  private List<Board> boards = new ArrayList<>();

  public Boardmap() {}

  @Builder
  public Boardmap(User user, String title){
    this.user = user;
    this.title = title;
  }
}
