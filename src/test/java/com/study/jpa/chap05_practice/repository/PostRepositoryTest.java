package com.study.jpa.chap05_practice.repository;

import com.study.jpa.chap05_practice.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class PostRepositoryTest {

  @Autowired
  PostRepository postRepository;

  @Test
  @DisplayName("bulk insert")
  void bulkInsert() {
      //given
    for (int i = 0; i < 378; i++) {
      postRepository.save(
      Post.builder()
          .title("하하호호제목" + i)
          .content("깔깔깔깔내용" + i)
          .writer("꾸까꾸까" + i)
          .build()
            );
    }
  }
}