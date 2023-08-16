package org.insta_project.member.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;

import org.insta_project.member.domain.IdCheckRequest;
import org.insta_project.member.domain.IdCheckResponse;
import org.insta_project.member.domain.MemberEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    @Transactional
    public MemberEntity save(MemberEntity member) {
        return memberRepository.save(member);
    }


    public IdCheckResponse checkUserId(IdCheckRequest idCheckRequest) {
        IdCheckResponse idCheckResponse = new IdCheckResponse();
        Optional<MemberEntity> getUser = memberRepository.findByUserId(idCheckRequest.getUserId());

        idCheckResponse.setResult(getUser.isEmpty());
        idCheckResponse.setMessage(getUser.isEmpty() ? "success" : "fail");
        return idCheckResponse;
    }
}
