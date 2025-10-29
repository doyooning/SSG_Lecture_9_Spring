package com.ssg.memberservicetest.mapper;

import com.ssg.memberservicetest.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
       int insert(MemberDTO member);
       List<MemberDTO> findAll();
       // userId는 컨트롤러에서 넘어오는 값
       MemberDTO findById(@Param("userId") String userId);
}
