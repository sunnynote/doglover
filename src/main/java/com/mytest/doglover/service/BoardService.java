package com.mytest.doglover.service;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

  private final BoardRepository boardRespository;

  public BoardService(BoardRepository boardRespository){
    this.boardRespository = boardRespository;
  }

  @Transactional
  public Board write(Board board){
    return boardRespository.save(board);
  }

  @Transactional
  public List<Board> findAllByBoardmap(Boardmap boardmap){
    return boardRespository.findAllByBoardmap(boardmap);
  }
}
