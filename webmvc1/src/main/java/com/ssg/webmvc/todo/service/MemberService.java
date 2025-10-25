package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dao.MemberDAO;
import com.ssg.webmvc.todo.domain.MemberVO;
import com.ssg.webmvc.todo.dto.MemberDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO VO = dao.getWithPassword(mid, mpw);
        MemberDTO dto = modelMapper.map(VO, MemberDTO.class);
        return dto;
    }
}
