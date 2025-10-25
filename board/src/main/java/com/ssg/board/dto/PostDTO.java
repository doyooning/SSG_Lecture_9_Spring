package com.ssg.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder // 객체 생성시 빌더 패턴으로
@Getter // 읽기만
@ToString // 객체값 확인
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long postId;
    private String title;
    private String content;
    private String writer;
    private String passphrase;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // getters/setters
}
