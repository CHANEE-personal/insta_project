package org.insta_project.member.service;

import org.assertj.core.api.Assertions;
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
}

