package com.ssg.board.dao;

import com.ssg.board.domain.PostVO;
import com.ssg.board.util.ConnectionUtil;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDAOImpl implements PostDAO {

    @Override
    public List<PostVO> findAll() {
        String sql = "select * from board_post order by updated_at desc";
        List<PostVO> list = new ArrayList<>();
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                PostVO vo = PostVO.builder()
                        .postId(rs.getLong("post_id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .passphrase(rs.getString("passphrase"))
                        .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                        .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
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
        String sql = "select * from board_post where post_id=?";

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setLong(1, id);

            try (ResultSet rs = pstmt.executeQuery();){
                rs.next();
                PostVO vo = PostVO.builder()
                        .postId(rs.getLong("post_id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .passphrase(rs.getString("passphrase"))
                        .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                        .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                        .build();
                return Optional.of(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public long save(PostVO post) {
        String sql = "insert into board_post(title, content, writer, passphrase) values(?,?,?,?)";

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getWriter());
            pstmt.setString(4, post.getPassphrase());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            long id = rs.getLong(1);
            return id;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public boolean update(PostVO post) {
        String sql = "update board_post set title = ?, content = ?, updated_at = now() where post_id = ?";
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setLong(3, post.getPostId());
            pstmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        String sql = "delete from board_post where post_id=?";

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkPassphrase(long id, String passphrase) {
        String sql = "select passphrase from board_post where post_id=?";

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery();) {
                rs.next();
                String currentPw = rs.getString("passphrase");
                boolean match = currentPw.equals(passphrase);
                return match;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
