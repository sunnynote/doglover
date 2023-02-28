package com.mytest.doglover.service;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.repository.BoardRespository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

  private final BoardRespository boardRespository;

  public BoardService(BoardRespository boardRespository){
    this.boardRespository = boardRespository;
  }

  @Transactional
  public Board write(Board board){
    return boardRespository.save(board);
  }
}
