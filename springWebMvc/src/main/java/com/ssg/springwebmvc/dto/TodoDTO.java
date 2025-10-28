package com.ssg.springwebmvc.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;

}
