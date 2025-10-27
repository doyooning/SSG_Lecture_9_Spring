package com.ssg.membertest;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDAO {
    void insertMember(Member member);
    List<Member> printMember();
}
