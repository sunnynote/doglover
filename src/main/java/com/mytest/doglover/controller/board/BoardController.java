package com.mytest.doglover.controller.board;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.service.BoardService;
import com.mytest.doglover.service.BoardmapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boardmap")
public class BoardController {

  private final BoardService boardService;
  private final BoardmapService boardmapService;

  @PostMapping("/{boardmapId}/write")
  public Long write(@PathVariable("boardmapId") Long boardmapId,
                    @RequestBody BoardRequest boardRequest){

    Boardmap boardmap = boardmapService.findById(boardmapId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

    return boardService.write(boardRequest
            .newBoard(boardmap, boardRequest.getTitle(), boardRequest.getContent()))
            .getId();
  }

  @GetMapping("/{boardmapId}")
  public ResponseEntity<List<BoardResponse>> boards(@PathVariable("boardmapId") Long boardmapId){

    Boardmap boardmap = boardmapService.findById(boardmapId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

    List<Board> boardList = boardService.findAllByBoardmap(boardmap);

    List<BoardResponse> collect = boardList.stream()
            .map(BoardResponse::new)
            .collect(Collectors.toList());

    return ResponseEntity.ok(collect);
  }

  @GetMapping("/{boardmapId}/{boardId}")
  public ResponseEntity<BoardResponse> board(@PathVariable("boardId") Long boardId){
    Board board = boardService.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

    BoardResponse boardResponse = new BoardResponse(board);

    return ResponseEntity.ok().body(boardResponse);
  }
}
