package com.ssg.springex.assignment;

import com.ssg.springex.servlet_dao.MemberVO;

import java.sql.*;

public class MemberRegisterDAO {
    private Statement stmt;
    private Connection conn;

    private void connDB() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul&charEncoding=UTF-8", "root", "mysql1234");
            System.out.println("Connection 생성 성공");
            stmt = conn.createStatement();
            System.out.println("Statement 생성 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다.");
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }

    public String saveMember(MemberRegisterVO vo) {

        try {
            connDB();
            String sql = "insert into memberinfo values(?, ?, ?, ?);";

            stmt.executeUpdate(sql);





            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
