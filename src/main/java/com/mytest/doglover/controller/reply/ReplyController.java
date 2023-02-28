package com.mytest.doglover.controller.reply;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Reply;
import com.mytest.doglover.model.user.User;
import com.mytest.doglover.model.user.UserAccount;
import com.mytest.doglover.service.BoardService;
import com.mytest.doglover.service.ReplyService;
import com.mytest.doglover.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boardmap")
public class ReplyController {

  private final ReplyService replyService;
  private final BoardService boardService;
  private final UserService userService;

  @PostMapping("/{boardmapId}/{boardId}/write")
  public Long write(@AuthenticationPrincipal UserAccount userAccount,
                    @PathVariable("boardId") Long boardId,
                    @RequestBody ReplyRequest replyRequest){


    Board board = boardService.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

    User user = userService.findByEmail(userAccount.getUsername())
            .orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 회원입니다."));

    return replyService.write(replyRequest
            .newReply(board, user, replyRequest.getContent()))
            .getId();
  }

  @GetMapping("/{boardmapId}/{boardId}/reply")
  public ResponseEntity<List<ReplyResponse>> read(@PathVariable("boardId") Long boardId){

    Board board = boardService.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

    List<Reply> replyList = replyService.findAllByBoard(board);

    List<ReplyResponse> collect = replyList.stream()
            .map(ReplyResponse::new)
            .collect(Collectors.toList());

    return ResponseEntity.ok(collect);
  }
}
