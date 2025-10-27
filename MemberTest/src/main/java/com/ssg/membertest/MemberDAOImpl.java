package com.ssg.membertest;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
@ToString
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void insertMember(Member member) {
        String sql = "insert into member values(?,?,?)";

        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, member.getMid());
            pstmt.setString(2, member.getMpw());
            pstmt.setString(3, member.getMname());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Member> printMember() {
        String sql = "select * from member";
        List<Member> members = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                Member member = Member.builder()
                        .mid(rs.getString(1))
                        .mpw(rs.getString(2))
                        .mname(rs.getString(3))
                        .build();
                members.add(member);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return members;
    }

}
