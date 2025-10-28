package com.ssg.springwebmvc.mapper;

import org.apache.ibatis.annotations.Select;

// DB의 현재 시각을 문자열로 처리하는 메서드 getTimeNow()
public interface TimeMapper {
    @Select("select now()")
    String getTimeNow();

}
