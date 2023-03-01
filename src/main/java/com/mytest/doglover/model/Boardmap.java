package com.mytest.doglover.model;

import com.mytest.doglover.model.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "MODEL: Boardmap")
@Entity
@Getter
public class Boardmap extends BaseTimeEntity {

  @ApiModelProperty(value = "게시판 번호")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BOARDMAP_NO")
  private Long id;

  @ApiModelProperty(value = "게시판 제목", required = true)
  private String title;

  @JoinColumn(name = "USER_NO")
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @OneToMany(mappedBy = "boardmap", cascade = CascadeType.ALL)
  private List<Board> boards = new ArrayList<>();

  public Boardmap() {}

  @Builder
  public Boardmap(User user, String title){
    this.user = user;
    this.title = title;
  }

  public void update(String title){
    this.title = title;
  }
}
