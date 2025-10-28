package com.ssg.membertest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Primary
@Repository
@RequiredArgsConstructor
public class MemberDAOImplSample implements MemberDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Member> MEMBER_ROW_MAPPER = new RowMapper<Member>(){

        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member member = Member.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                    .build();

            return member;
        }
    };

    @Override
    public int insertMember(Member member) {
        String sql = "insert into member values(?,?,?)";
        return jdbcTemplate.update(sql, member.getMid(), member.getMpw(), member.getMname());
    }

    @Override
    public List<Member> printMember() {
        String sql = "select * from member order by mid";
        return jdbcTemplate.query(sql, MEMBER_ROW_MAPPER);
    }
}
