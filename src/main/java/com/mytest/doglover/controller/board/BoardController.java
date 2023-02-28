package com.mytest.doglover.controller.board;

import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.service.BoardService;
import com.mytest.doglover.service.BoardmapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

}
