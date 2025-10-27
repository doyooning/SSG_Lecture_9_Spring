package com.ssg.membertest;

import java.util.List;

public interface MemberService {
    void insertMember(Member member);
    List<Member> printMember();
}
