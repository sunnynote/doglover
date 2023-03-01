package com.mytest.doglover.controller.user;

import com.mytest.doglover.model.user.User;
import com.mytest.doglover.model.user.UserAccount;
import com.mytest.doglover.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {"User API : 회원"})
@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  private final PasswordEncoder passwordEncoder;

  @PostMapping("/join")
  @ApiOperation(value = "회원 가입", notes = "이메일, 비밀번호, 닉네임을 입력하면 가입된다.")
  public ResponseEntity<User> join(@RequestBody JoinRequest joinRequest) {

    User joinUser = userService.join(joinRequest
            .newUser(joinRequest.getEmail(), passwordEncoder.encode(joinRequest.getPassword()), joinRequest.getNickname()));

    return ResponseEntity.ok().body(joinUser);
  }

  @PostMapping("/login")
  @ApiOperation(value = "로그인", notes = "이메일, 비밀번호를 입력하면 로그인된다.")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
    User user = userService.findByEmail(loginRequest.getEmail())
            .orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 회원입니다."));

    String token = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

    LoginResponse loginResponse = new LoginResponse(token, user.getNickname());

    return ResponseEntity.ok().body(loginResponse);
  }


  @PostMapping("/user/me")
  @ApiOperation(value = "회원 정보 수정", notes = "변경한 닉네임이 저장된다.")
  public ResponseEntity<User> updateMe(@ApiIgnore @AuthenticationPrincipal UserAccount userAccount,
                                       @RequestBody UserUpdateRequest userUpdateRequest){

    User user = userService.findByEmail(userAccount.getUsername())
            .orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 회원입니다."));

    userService.update(user, userUpdateRequest.getNickname());

    return ResponseEntity.ok().body(user);
  }

  @DeleteMapping("/user")
  @ApiOperation(value = "회원 탈퇴", notes = "회원 정보가 삭제된다.")
  public void delete(@ApiIgnore @AuthenticationPrincipal UserAccount userAccount){
    User user = userService.findByEmail(userAccount.getUsername())
            .orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 회원입니다."));

    userService.delete(user);
  }
}