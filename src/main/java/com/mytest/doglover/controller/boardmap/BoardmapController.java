package com.mytest.doglover.controller.boardmap;

import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.model.user.User;
import com.mytest.doglover.model.user.UserAccount;
import com.mytest.doglover.service.BoardmapService;
import com.mytest.doglover.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

  @PostMapping("/{boardmapId}")
  public Long update(@RequestBody BoardmapRequest boardmapRequest,
                     @PathVariable("boardmapId") Long boardmapId){
    Boardmap boardmap = boardmapService.findById(boardmapId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다"));

    return boardmapService.update(boardmap, boardmapRequest.getTitle());
  }

  @DeleteMapping("/{boardmapId}")
  public void delete(@PathVariable("boardmapId") Long boardmapId){
    Boardmap boardmap = boardmapService.findById(boardmapId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판 입니다"));

    boardmapService.delete(boardmap);
  }

  @GetMapping("")
  public ResponseEntity<List<BoardmapResponse>> boardmaps(){
    List<Boardmap> boardmapList = boardmapService.findAll();

    List<BoardmapResponse> collect = boardmapList.stream()
            .map(BoardmapResponse::new)
            .collect(Collectors.toList());

    return ResponseEntity.ok(collect);
  }
}
