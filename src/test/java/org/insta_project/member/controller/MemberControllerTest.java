package org.insta_project.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.insta_project.member.domain.IdCheckResponse;
import org.insta_project.member.domain.LoginRequest;
import org.insta_project.member.domain.LoginResponse;
import org.insta_project.member.domain.MemberEntity;
import org.insta_project.member.service.MemberRepository;
import org.insta_project.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@DisplayName("회원 관련 api")
@ExtendWith({RestDocumentationExtension.class})
@ActiveProfiles("dev")
@AutoConfigureRestDocs
@WebMvcTest(MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @MockBean
    private MemberService memberService;


    @BeforeEach
    public void before(WebApplicationContext was, RestDocumentationContextProvider restDocumentationContextProvider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(was)
                .apply(documentationConfiguration(restDocumentationContextProvider))
                .addFilters(new CharacterEncodingFilter("UTF-8", true)).alwaysDo(print()).build();
    }


    @Test
    @DisplayName("ID 중복 체크")
    void checkUserIdTest() throws Exception {

        IdCheckResponse idCheckResponse = new IdCheckResponse();
        idCheckResponse.setResult(true);
        idCheckResponse.setMessage("success");

        given(memberService.checkUserId("test")).willReturn(idCheckResponse);
        // when
        mockMvc.perform(get("/member/check").param("userId", "test")).andDo(MemberControllerDocs.checkUserId())
                .andDo(print());
    }


    @Test
    @DisplayName("회원가입")
    void saveMemberTest() throws Exception {
        // given
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(1L);
        memberEntity.setUserName("test");
        memberEntity.setUserId("test");
        memberEntity.setPassword("test");
        memberEntity.setUserPhone("010-1234-5678");
        memberEntity.setGender("m");
        memberEntity.setBirthDay("1999-09-09");
        memberEntity.setAddress("인천");
        memberEntity.setEmail("test@naver.com");

        given(memberService.save(any(MemberEntity.class))).willReturn(memberEntity);

        // when
        mockMvc.perform(post("/member/join").contentType(APPLICATION_JSON_VALUE).accept("application/json")
                        .content(objectMapper.writeValueAsString(memberEntity))).andDo(MemberControllerDocs.saveMember())
                .andDo(print());
    }


    @Test
    @DisplayName("로그인")
    void loginTest() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserId("test");
        loginRequest.setPassword("test");

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setResult(true);
        loginResponse.setMessage("success");

        given(memberService.login(any())).willReturn(loginResponse);

        // when
        mockMvc.perform(post("/member/login").contentType(APPLICATION_JSON_VALUE).accept("application/json")
                        .content(objectMapper.writeValueAsString(loginRequest))).andDo(MemberControllerDocs.login())
                .andDo(print());
    }
}
