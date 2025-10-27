package com.ssg.membertest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAOImpl memberDAOImpl;

    @Override
    public void insertMember(Member member) {
        memberDAOImpl.insertMember(member);
    }

    @Override
    public List<Member> printMember() {
        List<Member> members = memberDAOImpl.printMember();
        return members;
    }
}
