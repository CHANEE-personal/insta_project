package org.insta_project.member.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;

import org.insta_project.member.domain.IdCheckResponse;
import org.insta_project.member.domain.LoginRequest;
import org.insta_project.member.domain.LoginResponse;
import org.insta_project.member.domain.MemberEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberEntity save(MemberEntity member) {
        return memberRepository.save(member);
    }


    public IdCheckResponse checkUserId(String userId) {
        IdCheckResponse idCheckResponse = new IdCheckResponse();
        Optional<MemberEntity> getUser = memberRepository.findByUserId(userId);

        idCheckResponse.setResult(getUser.isEmpty());
        idCheckResponse.setMessage(getUser.isEmpty() ? "success" : "fail");
        return idCheckResponse;
    }


    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        Optional<MemberEntity> getUser =
                memberRepository.findByUserIdAndPassword(loginRequest.getUserId(), loginRequest.getPassword());

        loginResponse.setResult(getUser.isPresent());
        loginResponse.setMessage(getUser.isPresent() ? "success" : "fail");

        return loginResponse;
    }
}
