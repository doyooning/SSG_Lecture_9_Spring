package com.ssg.todoservice.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;

    @NotEmpty
    private String title;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer;
}
