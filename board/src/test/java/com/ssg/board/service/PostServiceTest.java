package com.ssg.board.service;

import com.ssg.board.dto.PostDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PostServiceTest {
    private PostService postService;

    @BeforeEach
    public void ready() {
        postService = PostService.INSTANCE;
    }

    @Test
    void getList() {
        List<PostDTO> postDTOList = postService.getList();
        System.out.println(postDTOList);
    }

    @Test
    void getDetail() {
        PostDTO postDTO = postService.getDetail(1);
        System.out.println(postDTO);
    }

    @Test
    void write() {
        PostDTO postDTO1 = PostDTO.builder()
                .postId(9L)
                .title("untitled")
                .content("1")
                .writer("writer1")
                .passphrase("1111")
                .build();
        System.out.println("content check: " + postService.write(postDTO1));

        PostDTO postDTO2 = PostDTO.builder()
                .postId(10L)
                .title("untitled2")
                .content("contents")
                .writer("writer2")
                .passphrase("1")
                .build();
        System.out.println("passphrase check: " + postService.write(postDTO2));
    }

    @Test
    void edit() {
        PostDTO postDTO = PostDTO.builder()
                .postId(1L)
                .title("untitled")
                .content("contents")
                .writer("writer")
                .passphrase("1234")
                .build();
        String inputPp1 = "0000";
        System.out.println("Passphrase check: " + postService.edit(postDTO, inputPp1));
        String inputPp2 = "1234"; // 실제 passphrase -> 참
        System.out.println("Passphrase check: " + postService.edit(postDTO, inputPp2));

    }

    @Test
    void remove() {
        long postId = 1L;
        String inputPp1 = "0000";
        System.out.println("Passphrase check: " + postService.remove(postId, inputPp1));
        String inputPp2 = "1234"; // 실제 passphrase -> 참
        System.out.println("Passphrase check: " + postService.remove(postId, inputPp2));
    }
}