package com.sparta.todoapp.service;

import com.sparta.todoapp.dto.PostAddRequestDto;
import com.sparta.todoapp.dto.PostResponseDto;
import com.sparta.todoapp.dto.PostUpdateRequestDto;
import com.sparta.todoapp.dto.ResponseDto;
import com.sparta.todoapp.entity.Post;
import com.sparta.todoapp.entity.User;
import com.sparta.todoapp.jwt.JwtUtil;
import com.sparta.todoapp.repository.PostJpaRepository;
import com.sparta.todoapp.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final의 생성자 생략
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public PostResponseDto addPost(PostAddRequestDto requestDto, HttpServletRequest res) { // 저장하는 코드 작성

        String token = jwtUtil.resolveToken(res);
        Claims claims;

        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            Post post = new Post(requestDto, user.getUsername());

            Post savePost = PostJpaRepository.save(post);
            return new PostResponseDto(savePost);
        } else {
            throw new IllegalArgumentException("토큰이 존재하지 않습니다.");
        }
    }
}

        /*// Dto -> Entity (영속화)
        Post post = new Post(requestDto);

        Post savePost = postJpaRepository.save(post);
        // postJpaRepository.savePost(post).var;
        return new PostResponseDto(savePost);


    public PostResponseDto getPost(Long postId) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("해당 게시글을 찾을 수 없습니다."));
        return new PostResponseDto(post);
    }

    public List<PostResponseDto> getPosts() {
        return postJpaRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponseDto::new).toList();
    }

    @Transactional
    public PostResponseDto updatePost(Long postId, PostUpdateRequestDto requestDto) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("해당 게시글을 찾을 수 없습니다."));

        if(!post.getPassword().equals(requestDto.getPassword())) {
            throw new NullPointerException("비밀번호가 일치하지 않습니다.");
        }
        post.update(requestDto);

        return new PostResponseDto(post);
    }

    public void deletePost(Long postId, String password) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("해당 게시글을 찾을 수 없습니다."));

        if(!post.getPassword().equals(password)) {
            throw new NullPointerException("비밀번호가 일치하지 않습니다.");
        }
        postJpaRepository.delete(post);
    }*/
