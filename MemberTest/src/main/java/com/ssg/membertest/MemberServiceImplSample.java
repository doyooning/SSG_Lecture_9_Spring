package com.ssg.membertest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Primary
@Service
@RequiredArgsConstructor
public class MemberServiceImplSample implements MemberService {
    private final MemberDAO memberDAO;

    @Transactional
    @Override
    public void joinMember(Member member) {
        memberDAO.insertMember(member);
    }

    @Transactional
    @Override
    public List<Member> memberList() {
        return memberDAO.printMember();
    }
}
