package com.mytest.doglover.controller.boardmap;

import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.model.user.User;
import com.mytest.doglover.model.user.UserAccount;
import com.mytest.doglover.service.BoardmapService;
import com.mytest.doglover.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.stream.Collectors;


@Api(tags = {"Boardmap API : 게시판"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/boardmap")
public class BoardmapController {

  private final BoardmapService boardmapService;
  private final UserService userService;

  @PostMapping("/create")
  @ApiOperation(value = "게시판 생성", notes = "게시판이 생성된다.")
  public Long create(@ApiIgnore @AuthenticationPrincipal UserAccount userAccount,
                     @RequestBody BoardmapRequest boardmapRequest){
    User user = userService.findByEmail(userAccount.getUsername())
            .orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 회원입니다."));

    return boardmapService.create(boardmapRequest
            .newBoardmap(user, boardmapRequest.getTitle()))
            .getId();
  }

  @PostMapping("/{boardmapId}")
  @ApiOperation(value = "게시판 수정", notes = "게시판 제목을 수정한다.")
  public Long update(@RequestBody BoardmapRequest boardmapRequest,
                     @PathVariable("boardmapId") Long boardmapId){
    Boardmap boardmap = boardmapService.findById(boardmapId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다"));

    return boardmapService.update(boardmap, boardmapRequest.getTitle());
  }

  @DeleteMapping("/{boardmapId}")
  @ApiOperation(value = "게시판 삭제", notes = "게시판을 삭제한다.")
  public void delete(@PathVariable("boardmapId") Long boardmapId){
    Boardmap boardmap = boardmapService.findById(boardmapId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판 입니다"));

    boardmapService.delete(boardmap);
  }

  @GetMapping("")
  @ApiOperation(value = "게시판 목록 조회", notes = "현재 생성된 게시판 목록을 조회한다.")
  public ResponseEntity<List<BoardmapResponse>> boardmaps(){
    List<Boardmap> boardmapList = boardmapService.findAll();

    List<BoardmapResponse> collect = boardmapList.stream()
            .map(BoardmapResponse::new)
            .collect(Collectors.toList());

    return ResponseEntity.ok(collect);
  }
}
