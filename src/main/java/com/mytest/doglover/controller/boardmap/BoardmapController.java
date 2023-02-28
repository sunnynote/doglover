package com.mytest.doglover.controller.boardmap;

import com.mytest.doglover.model.user.User;
import com.mytest.doglover.model.user.UserAccount;
import com.mytest.doglover.service.BoardmapService;
import com.mytest.doglover.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boardmap")
public class BoardmapController {

  private final BoardmapService boardmapService;
  private final UserService userService;

  @PostMapping("/create")
  public Long create(@AuthenticationPrincipal UserAccount userAccount,
                     @RequestBody BoardmapRequest boardmapRequest){
    User user = userService.findByEmail(userAccount.getUsername())
            .orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 회원입니다."));

    return boardmapService.create(boardmapRequest
            .newBoardmap(user, boardmapRequest.getTitle()))
            .getId();
  }

}
