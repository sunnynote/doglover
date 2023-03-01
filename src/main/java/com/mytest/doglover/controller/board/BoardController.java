package com.mytest.doglover.controller.board;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.service.BoardService;
import com.mytest.doglover.service.BoardmapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = {"Board API : 게시물"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/boardmap")
public class BoardController {

  private final BoardService boardService;
  private final BoardmapService boardmapService;

  @PostMapping("/{boardmapId}/write")
  @ApiOperation(value = "게시물 작성", notes = "해당 게시판에 게시물이 작성된다.")
  public Long write(@PathVariable("boardmapId") Long boardmapId,
                    @RequestBody BoardRequest boardRequest){

    Boardmap boardmap = boardmapService.findById(boardmapId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

    return boardService.write(boardRequest
            .newBoard(boardmap, boardRequest.getTitle(), boardRequest.getContent()))
            .getId();
  }

  @GetMapping("/{boardmapId}")
  @ApiOperation(value = "해당 게시판의 게시물 전체 조회", notes = "해당 게시판의 게시물 전체를 조회한다.")
  public ResponseEntity<List<BoardResponse>> readAll(@PathVariable("boardmapId") Long boardmapId){

    Boardmap boardmap = boardmapService.findById(boardmapId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

    List<Board> boardList = boardService.findAllByBoardmap(boardmap);

    List<BoardResponse> collect = boardList.stream()
            .map(BoardResponse::new)
            .collect(Collectors.toList());

    return ResponseEntity.ok(collect);
  }

  @GetMapping("/{boardmapId}/{boardId}")
  @ApiOperation(value = "게시물 개별 조회", notes = "해당 게시물을 상세 조회한다.")
  public ResponseEntity<BoardResponse> readOne(@PathVariable("boardId") Long boardId){
    Board board = boardService.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

    BoardResponse boardResponse = new BoardResponse(board);

    return ResponseEntity.ok().body(boardResponse);
  }

  @PostMapping("/{boardmapId}/{boardId}")
  @ApiOperation(value = "게시물 수정", notes = "해당 게시물의 제목이나 내용을 수정한다.")
  public Long update(@RequestBody BoardRequest boardRequest,
                     @PathVariable("boardId") Long boardId){

    Board board = boardService.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

    boardService.update(board, boardRequest.getTitle(), boardRequest.getContent());

    return boardId;
  }

  @DeleteMapping("/{boardmapId}/{boardId}")
  @ApiOperation(value = "게시물 삭제", notes = "해당 게시물을 삭제한다.")
  public void delete(@PathVariable("boardId") Long boardId){

    Board board = boardService.findById(boardId)
           .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

   boardService.delete(board);
  }
}
