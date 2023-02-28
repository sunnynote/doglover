package com.mytest.doglover.service;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

  @Transactional
  public Optional<Board> findById(Long id){
    return boardRespository.findById(id);
  }

  @Transactional
  public Long update(Board board, String title, String content){
    board.update(title, content);
    return boardRespository.save(board).getId();
  }

  @Transactional
  public void delete(Board board){
    boardRespository.delete(board);
  }
}
