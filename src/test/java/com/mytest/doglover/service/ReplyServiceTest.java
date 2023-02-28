package com.mytest.doglover.service;

import com.mytest.doglover.model.Board;
import com.mytest.doglover.model.Boardmap;
import com.mytest.doglover.model.Reply;
import com.mytest.doglover.model.user.User;
import com.mytest.doglover.repository.ReplyRepository;
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
public class ReplyServiceTest {

  @Mock
  ReplyRepository replyRepository;

  @InjectMocks
  ReplyService replyService;

  @Test
  @DisplayName("댓글 생성 테스트")
  void reply_write(){

    // given
    Reply mockReply = Reply.builder()
            .board(new Board(new Boardmap(new User("sunny"), "boardmap"), "board title", "board content"))
            .content("reply content")
            .build();

    when(replyRepository.save(any())).thenReturn(mockReply);

    // when
    Reply reply = replyService.write(mockReply);

    // then
    assertThat(reply.getContent(), is("reply content"));
  }
}
