package com.mytest.doglover.repository;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
  List<Reply> findAllByBoard(Board board);
}
