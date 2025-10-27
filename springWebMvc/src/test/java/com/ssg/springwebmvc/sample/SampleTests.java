package com.ssg.springwebmvc.sample;

import com.ssg.springwebmvc.prof.Classroom;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class) // JUnit 버전에서 spring-test 이용하기 위한 어노테이션
// 스프링 설정 정보 로딩 위한 어노테이션
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTests {
    // 스프링에서 사용하는 의존성 주입 어노테이션
    @Autowired
    private SampleService sampleService; // 멤버 변수 선언
    //
    @Autowired
    private Restaurant restaurant;

    @Autowired
    private Classroom classroom;
    @Autowired
    private DataSource dataSource;

//    @Test
//    public void testSampleService() {
//        log.info(sampleService);
//        Assertions.assertNotNull(sampleService);
//    }

    @Test
    public void testRestaurant() {
        log.info(restaurant);
        Assertions.assertNotNull(restaurant);
    }

    @Test
    public void testClassroom() {
        log.info(classroom);
        Assertions.assertNotNull(classroom);
    }

    @Test
    public void testDataSource() throws Exception {
        Connection conn = dataSource.getConnection();
        log.info(conn);
        Assertions.assertNotNull(conn);

        conn.close();
    }

}