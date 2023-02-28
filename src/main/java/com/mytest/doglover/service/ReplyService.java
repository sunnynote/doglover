package com.mytest.doglover.service;

import com.mytest.doglover.model.Reply;
import com.mytest.doglover.repository.ReplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
