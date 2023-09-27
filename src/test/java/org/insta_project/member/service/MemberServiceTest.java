package org.insta_project.member.service;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.insta_project.member.domain.IdCheckResponse;
import org.insta_project.member.domain.LoginRequest;
import org.insta_project.member.domain.LoginResponse;
import org.insta_project.member.domain.MemberEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;


    @Mock
    private MemberRepository memberRepository;


    @Test
    @DisplayName("ID 중복 체크")
    void checkUserIdTest() {
        // 중복된 아이디
        MemberEntity member = new MemberEntity();
        member.setUserId("test");
        member.setUserName("test");
        member.setPassword("password");
        memberRepository.save(member);

        given(memberRepository.findByUserId(member.getUserId())).willReturn(Optional.of(member));

        IdCheckResponse idCheckResponse = memberService.checkUserId("test");
        Assertions.assertThat(idCheckResponse.isResult()).isFalse();

        // 중복되지 않은 아이디
        IdCheckResponse idCheckResponse1 = memberService.checkUserId("test1");
        Assertions.assertThat(idCheckResponse1.isResult()).isTrue();
    }


    @Test
    @DisplayName("회원가입")
    void saveMemberTest() {
        // given
        MemberEntity member = new MemberEntity();
        member.setUserId("test");
        member.setUserName("test");
        member.setPassword("password");

        given(memberRepository.save(member)).willReturn(member);

        // when
        MemberEntity saveMember = memberService.save(member);
        // then
        Assertions.assertThat(saveMember.getUserId()).isEqualTo("test");
    }


    @Test
    @DisplayName("로그인")
    void loginTest() {
        // given
        MemberEntity member = new MemberEntity();
        member.setUserId("test");
        member.setUserName("test");
        member.setPassword("password");

        given(memberRepository.findByUserIdAndPassword(member.getUserId(), member.getPassword())).willReturn(
                Optional.of(member));

        // when
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserId(member.getUserId());
        loginRequest.setPassword(member.getPassword());
        LoginResponse response = memberService.login(loginRequest);

        // then
        Assertions.assertThat(response.isResult()).isTrue();
        Assertions.assertThat(response.getMessage()).isEqualTo("success");
    }
}

