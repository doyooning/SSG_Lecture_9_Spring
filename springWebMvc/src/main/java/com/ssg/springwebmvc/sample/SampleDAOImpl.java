package com.ssg.springwebmvc.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("normal")// 해당 클래스의 객체를 스프링의 Bean으로 처리함
public class SampleDAOImpl implements SampleDAO { // 느슨한 결합

}
