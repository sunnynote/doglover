package com.mytest.doglover.service;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.model.user.User;
import com.mytest.doglover.repository.BoardRepository;
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
public class BoardServiceTest {

  @Mock
  BoardRepository boardRepository;

  @InjectMocks
  BoardService boardService;

  @Test
  @DisplayName("게시물 생성 테스트")
  void board_write(){

    //given
    Board mockBoard = Board.builder()
            .boardmap(new Boardmap(new User("sunny"), "boardmap title"))
            .title("board title")
            .content("board content")
            .build();

    when(boardRepository.save(any())).thenReturn(mockBoard);

    // when
    Board board = boardService.write(mockBoard);

    // then
    assertThat(board.getTitle(), is("board title"));
  }
}
