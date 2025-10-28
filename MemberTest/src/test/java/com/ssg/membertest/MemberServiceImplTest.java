package com.ssg.membertest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations =
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberServiceImplTest {

    @Qualifier("memberServiceImplSample")
    @Autowired
    MemberService memberService;

    @Test
    @Transactional
    @Rollback(false)
    void joinMember() {
        Member member = Member.builder()
                .mid("shinsegae")
                .mpw("123456")
                .mname("신세계")
                .build();
        memberService.joinMember(member);
    }

    @Test
    void memberList() {
        memberService.memberList().forEach(System.out::println);
    }
}
