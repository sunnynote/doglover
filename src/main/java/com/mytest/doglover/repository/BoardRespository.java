package com.mytest.doglover.repository;

import com.mytest.doglover.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRespository extends JpaRepository<Board, Long> {
}
