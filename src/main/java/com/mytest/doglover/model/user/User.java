package com.mytest.doglover.model.user;

import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.model.Reply;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ApiModel(value = "MODEL: User")
@Entity
@Getter
public class User implements UserDetails {

  @ApiModelProperty(value = "회원 번호")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_NO")
  private Long id;

  @ApiModelProperty(value = "이메일", required = true)
  private String email;

  @ApiModelProperty(value = "비밀번호", required = true)
  private String password;

  @ApiModelProperty(value = "닉네임", required = true)
  private String nickname;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Boardmap> boardmaps = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Reply> replies = new ArrayList<>();

  @ElementCollection(fetch = FetchType.EAGER)
  @Builder.Default
  private List<String> roles = new ArrayList<>();

  public User() {}

  public User(String email){
    this.email = email;
  }

  public User(String email, String password){
    this.email = email;
    this.password = password;
  }

  @Builder
  public User(String email, String password, String nickname){
    this.email = email;
    this.password = password;
    this.nickname = nickname;
  }

  public void update(String nickname){
    this.nickname = nickname;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }
}
