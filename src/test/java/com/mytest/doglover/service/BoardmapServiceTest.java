package com.mytest.doglover.service;

import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.model.user.User;
import com.mytest.doglover.repository.BoardmapRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BoardmapServiceTest {

  @Mock
  BoardmapRepository boardmapRepository;

  @InjectMocks
  BoardmapService boardmapService;

  @Test
  @DisplayName("게시판 생성 테스트")
  void boardmap_create(){

    //given
    Boardmap mockBoardmap = Boardmap.builder()
            .user(new User("doglover@gmail.com"))
            .title("boardmap create")
            .build();

    when(boardmapRepository.save(any())).thenReturn(mockBoardmap);

    // when
    Boardmap boardmap = boardmapService.create(mockBoardmap);

    // then
    assertThat(boardmap.getTitle(), is("boardmap create"));
  }
}
