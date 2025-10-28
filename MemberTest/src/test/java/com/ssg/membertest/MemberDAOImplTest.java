package com.ssg.membertest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.Connection;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class) // JUnit 버전에서 spring-test 이용하기 위한 어노테이션
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberDAOImplTest {

    @Autowired
    private MemberDAOImpl memberDAO;

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void insertMember() {
        Member member = Member.builder()
                .mid("member45")
                .mpw("1235")
                .mname("신길동")
                .build();
        log.info(member.toString());
        memberService.joinMember(member);
    }

    @Test
    public void printMember() {
        List<Member> members = memberService.memberList();
        for (Member member : members) {
            log.info(member.toString());
        }
    }
}