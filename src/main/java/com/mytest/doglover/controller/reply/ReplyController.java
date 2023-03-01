package com.mytest.doglover.controller.reply;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Reply;
import com.mytest.doglover.model.user.User;
import com.mytest.doglover.model.user.UserAccount;
import com.mytest.doglover.service.BoardService;
import com.mytest.doglover.service.ReplyService;
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

@Api(tags = {"Reply API : 댓글"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/boardmap")
public class ReplyController {

  private final ReplyService replyService;
  private final BoardService boardService;
  private final UserService userService;

  @PostMapping("/{boardmapId}/{boardId}/write")
  @ApiOperation(value = "댓글 작성", notes = "해당 게시물에 댓글을 작성한다.")
  public Long write(@ApiIgnore @AuthenticationPrincipal UserAccount userAccount,
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
  @ApiOperation(value = "해당 게시물의 전체 댓글 조회", notes = "해당 게시물에 작성된 전체 댓글을 조회한다.")
  public ResponseEntity<List<ReplyResponse>> read(@PathVariable("boardId") Long boardId){

    Board board = boardService.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

    List<Reply> replyList = replyService.findAllByBoard(board);

    List<ReplyResponse> collect = replyList.stream()
            .map(ReplyResponse::new)
            .collect(Collectors.toList());

    return ResponseEntity.ok(collect);
  }

  @DeleteMapping("/{boardmapId}/{boardId}/reply/{replyId}")
  @ApiOperation(value = "댓글 삭제", notes = "해당 댓글을 삭제한다.")
  public void delete(@PathVariable("replyId") Long replyId){

    Reply reply = replyService.findById(replyId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

    replyService.delete(reply);
  }
}
