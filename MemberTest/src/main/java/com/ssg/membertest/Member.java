package com.ssg.membertest;

import lombok.*;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Member {
    private String mid;
    private String mpw;
    private String mname;
}
