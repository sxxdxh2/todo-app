package com.sparta.todoapp.dto;

import com.sparta.todoapp.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long id; // 게시글 수정을 위한 고유한 값을 알아야 함
    private String title;
    private String username;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
 // private String password; // 반환 받은 게시글의 정보에 비밀번호는 제외 되어있습니다.

    public PostResponseDto(Post savePost) {
        this.id = savePost.getId();
        this.title = savePost.getTitle();
        this.username = savePost.getUsername();
        this.content = savePost.getContents();
        this.createdAt = savePost.getCreatedAt(); // TimeEntity
        this.modifiedAt = savePost.getModifiedAt();
    }
}
