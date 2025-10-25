package com.ssg.board.service;

import com.ssg.board.dao.PostDAO;
import com.ssg.board.dao.PostDAOImpl;
import com.ssg.board.domain.PostVO;
import com.ssg.board.dto.PostDTO;
import com.ssg.board.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public enum PostService {
    INSTANCE;

    private PostDAO dao;
    private ModelMapper modelMapper;

    PostService() {
        this.dao = new PostDAOImpl();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public List<PostDTO> getList() {
        List<PostVO> voList = dao.findAll();
        List<PostDTO> dtoList = voList.stream().map(
                vo -> modelMapper.map(vo, PostDTO.class)).collect(Collectors.toList());
        return dtoList;
    }

    public PostDTO getDetail(long id) {
        return null;
    }
    // 조회수 증가 포함
    public long write(PostDTO post) {
        return 0L;
    }
    // 검증 + 저장
    public void edit(PostDTO post, String passphrase) {}
    // 비번검증 + 수정
    public void remove(long id, String passphrase) {}
    // 비번검증 + 삭제
}

