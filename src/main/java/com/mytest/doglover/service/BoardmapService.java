package com.mytest.doglover.service;

import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.repository.BoardmapRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardmapService {

  private final BoardmapRepository boardmapRepository;

  public BoardmapService(BoardmapRepository boardmapRepository) {
    this.boardmapRepository = boardmapRepository;
  }

  @Transactional
  public Boardmap create(Boardmap boardmap) {
    return boardmapRepository.save(boardmap);
  }

  @Transactional
  public Long update(Boardmap boardmap, String title){
    boardmap.update(title);
    return boardmapRepository.save(boardmap).getId();
  }

  @Transactional
  public void delete(Boardmap boardmap){
    boardmapRepository.delete(boardmap);
  }

  @Transactional
  public Optional<Boardmap> findById(Long id){
    return boardmapRepository.findById(id);
  }

  @Transactional
  public List<Boardmap> findAll(){
    return boardmapRepository.findAll();
  }
}