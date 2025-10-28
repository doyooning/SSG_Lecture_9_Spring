package com.ssg.membertest;

import java.util.List;

public interface MemberService {
    void joinMember(Member member);
    List<Member> memberList();
}
