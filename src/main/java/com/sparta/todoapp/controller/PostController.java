package com.sparta.todoapp.controller;

import com.sparta.todoapp.dto.PostAddRequestDto;
import com.sparta.todoapp.dto.PostResponseDto;
import com.sparta.todoapp.dto.PostUpdateRequestDto;
import com.sparta.todoapp.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final의 생성자 생략
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping // 작성
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponseDto addPost(@RequestBody PostAddRequestDto requestDto, HttpServletRequest res) {
        return postService.addPost(requestDto,res);
    }

   /* @GetMapping("/{postId}") // 상세 조회
    public PostResponseDto getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @GetMapping // 전체 조회 (List)
    public List<PostResponseDto> getPosts() { // 전체 조회는 정보를 받아오지 않아도 됨
        return postService.getPosts();
    }

    @PatchMapping("/{postId}") // 수정
    public PostResponseDto updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequestDto requestDto, HttpServletRequest res) {
        return postService.updatePost(postId, requestDto, res);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 성공 시 200이 아닌 204 NO CONTENT
    @DeleteMapping("/{postId}") // 삭제
    public void deletePost(@PathVariable Long postId, HttpServletRequest res) {
        postService.deletePost(postId, res);

    }*/
}
