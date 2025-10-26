package com.ssg.board.service;

import com.ssg.board.dao.PostDAO;
import com.ssg.board.dao.PostDAOImpl;
import com.ssg.board.domain.PostVO;
import com.ssg.board.dto.PostDTO;
import com.ssg.board.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
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
        Optional<PostVO> postVO = dao.findById(id);
        if (postVO.isPresent()) {
            PostVO vo = postVO.get();
            PostDTO postDTO = modelMapper.map(vo, PostDTO.class);
            return postDTO;
        }
        return null;
    }
    // 조회수 증가 포함
    public long write(PostDTO post) {

        String titleRegix = "^.{2,200}$";
        String contentRegix = "^.{5,}$";
        String writerRegix = "^.{1,50}$";
        String passphraseRegix = "^.{4,20}$";

        log.info("post: " + post.toString());
        if (!post.getTitle().matches(titleRegix)) {
            return 0L;
        } else if (!post.getContent().matches(contentRegix)) {
            return 0L;
        } else if (!post.getWriter().matches(writerRegix)) {
            return 0L;
        } else if (!post.getPassphrase().matches(passphraseRegix)) {
            return 0L;
        }
        // 검증 다 끝내고 저장 -> dao.save()
        PostVO postVO = modelMapper.map(post, PostVO.class);
        long result = dao.save(postVO);
        log.info("result: " + result);
        return result;
    }
    // 검증 + 저장
    public boolean edit(PostDTO post, String passphrase) {
        boolean result = false;
        PostVO postVO = modelMapper.map(post, PostVO.class);
        if (dao.checkPassphrase(post.getPostId(), passphrase)) {
            result = dao.update(postVO);
        }
        return result;
    }
    // 비번검증 + 수정
    public boolean remove(long id, String passphrase) {
        // dao.checkpassphrase로 비번검증
        boolean result = false;
        if (dao.checkPassphrase(id, passphrase)) {
            result = dao.delete(id);
        }
        return result;
    }
    // 비번검증 + 삭제
}

