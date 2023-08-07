package org.insta_project.member.service;

import lombok.RequiredArgsConstructor;

import org.insta_project.member.domain.MemberEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    @Transactional
    public MemberEntity save(MemberEntity member) {
        System.out.println(member.getUserId());
        return memberRepository.save(member);
    }
}
