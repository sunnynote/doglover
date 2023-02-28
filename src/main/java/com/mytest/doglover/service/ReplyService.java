package com.mytest.doglover.service;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Reply;
import com.mytest.doglover.repository.ReplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {

  private final ReplyRepository replyRepository;

  public ReplyService(ReplyRepository replyRepository){
    this.replyRepository = replyRepository;
  }
  @Transactional
  public Reply write(Reply reply){
    return replyRepository.save(reply);
  }

  @Transactional
  public List<Reply> findAllByBoard(Board board){
    return replyRepository.findAllByBoard(board);
  }

  @Transactional
  public Optional<Reply> findById(Long id){
    return replyRepository.findById(id);
  }

  @Transactional
  public void delete(Reply reply){
    replyRepository.delete(reply);
  }
}
