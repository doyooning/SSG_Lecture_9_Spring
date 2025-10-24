package com.ssg.webmvc.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Builder // 객체 생성시 빌더 패턴으로
@Getter // 읽기만
@ToString // 객체값 확인
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
