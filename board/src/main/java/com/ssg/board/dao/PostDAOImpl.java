package com.ssg.board.dao;

import com.ssg.board.domain.PostVO;
import com.ssg.board.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDAOImpl implements PostDAO {

    @Override
    public List<PostVO> findAll() {
        String sql = "select * from board_post";
        List<PostVO> list = new ArrayList<>();
        try (@Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
             @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
             @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                PostVO vo = PostVO.builder()
                        .postId(resultSet.getLong("postId"))
                        .title(resultSet.getString("title"))
                        .content(resultSet.getString("content"))
                        .writer(resultSet.getString("writer"))
                        .passphrase(resultSet.getString("passphrase"))
                        .createdAt(LocalDateTime.from(resultSet.getDate("createdAt").toLocalDate()))
                        .updatedAt(LocalDateTime.from(resultSet.getDate("updatedAt").toLocalDate()))
                        .build();
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean countAll() {
        return false;
    }

    @Override
    public Optional<PostVO> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long save(PostVO post) {
        return 0;
    }

    @Override
    public boolean update(PostVO post) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean checkPassphrase(long id, String passphrase) {
        return false;
    }
}
