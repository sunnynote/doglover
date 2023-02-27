package com.mytest.doglover.service;

import com.mytest.doglover.model.user.User;
import com.mytest.doglover.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

  @Mock
  UserRepository userRepository;

  @InjectMocks
  UserService userService;

  @Test
  @DisplayName("회원 가입")
  void join_test() {

    //given
    User mockUser = User.builder()
            .email("doglover@gmail.com")
            .password("1234")
            .nickname("sunny")
            .build();

    when(userRepository.save(any())).thenReturn(mockUser);

    // when
    User user = userService.join(mockUser);

    // then
    assertThat(user.getEmail(), is("hi@hi.com"));
  }

  @Test
  @DisplayName("회원 닉네임 수정하기")
  void update_test() {

    // given
    User mockUser = User.builder()
            .email("doglover@gmail.com")
            .password("1234")
            .nickname("sunny")
            .build();

    // when
    userService.update(mockUser, "cloud");

    // then
    assertThat(mockUser.getNickname(), is("cloud"));
  }

  @Test
  @DisplayName("이메일으로 회원 찾기")
  void findByEmail() {

    // given
    User user = User.builder()
            .email("doglover@gmail.com")
            .password("1234")
            .nickname("sunny")
            .build();

    // when
    Optional<User> mockUser = Optional.of(user);
    when(userService.findByEmail(any())).thenReturn(mockUser);

    Optional<User> actualUser = this.userService.findByEmail(user.getEmail());

    // then
    assertThat(user.getId(), is(actualUser.get().getId()));
    assertThat(user.getEmail(), is(actualUser.get().getEmail()));
  }
}
