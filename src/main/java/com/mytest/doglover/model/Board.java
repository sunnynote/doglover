package com.mytest.doglover.model;

import com.mytest.doglover.model.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "MODEL: Board")
@Entity
@Getter
public class Board extends BaseTimeEntity {

  @ApiModelProperty(value = "게시물 번호")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BOARD_NO")
  private Long id;

  @ApiModelProperty(value = "게시물 제목", required = true)
  private String title;

  @ApiModelProperty(value = "게시물 내용", required = true)
  private String content;

  @JoinColumn(name = "BOARDMAP_NO")
  @ManyToOne(fetch = FetchType.LAZY)
  private Boardmap boardmap;

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
  private List<Reply> replyList = new ArrayList<>();

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
