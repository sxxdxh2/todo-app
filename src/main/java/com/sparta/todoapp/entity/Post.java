package com.sparta.todoapp.entity;

import com.sparta.todoapp.dto.PostAddRequestDto;
import com.sparta.todoapp.dto.PostUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Entity는 기본생성자가 필요함
public class Post extends TimeEntity { // Post 객체 하나가 테이블에서 한 줄
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20) // 필드 만들기
    private String title;
    @Column(nullable = false, length = 15)
    private String username;
    @Column(nullable = false, length = 500)
    private String contents;

    public Post(PostAddRequestDto requestDto, String username) {
        this.title = requestDto.getTitle();
        this.username = username;
        this.contents = requestDto.getContent();
    }

    public void update(PostUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContent();
    }
}