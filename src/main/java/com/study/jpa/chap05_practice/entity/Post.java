package com.study.jpa.chap05_practice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@ToString(exclude = {"hashTags"}) // post에서 hashTags 제거
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_no")
  private Long id;

  @Column(nullable = false)
  private String writer; // 작성자

  @Column(nullable = false)
  private String title; // 제목
  private String content; // 내용

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createDate; // 작성시간

  @UpdateTimestamp
  private LocalDateTime updateDate; // 수정시간

  // db에 넣는게 아니고 연관관계를 나타낸다.
  @OneToMany(mappedBy = "post", orphanRemoval = true) // 상대방 별칭을 적어줘야 한다
  @Builder.Default
  private List<HashTag> hashTags = new ArrayList<>();

  public void addHashTag(HashTag hashTag){
    hashTags.add(hashTag);
    if (this != hashTag.getPost()) {
      hashTag.setPost(this);
    }
  }
}