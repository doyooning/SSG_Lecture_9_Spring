package com.ssg.springboard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
    private Long rno;
    private Long bno;
    private String replyText;
    private String replier;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime regDate;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime updateDate;
}
