package com.mytest.doglover.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

  @Id
  @GeneratedValue
  @Column(name = "USER_NO")
  private Long id;

  private String email;

  private String password;

  private String nickname;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Boardmap> boardmaps = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Reply> replies = new ArrayList<>();

}
