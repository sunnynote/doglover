package com.mytest.doglover.repository;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Boardmap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
  List<Board> findAllByBoardmap(Boardmap boardmap);
}
