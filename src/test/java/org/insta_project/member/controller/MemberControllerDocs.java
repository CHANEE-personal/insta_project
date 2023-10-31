package org.insta_project.member.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import static org.springframework.restdocs.payload.JsonFieldType.BOOLEAN;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import org.springframework.test.web.servlet.ResultHandler;

public class MemberControllerDocs {

    public static RestDocumentationResultHandler saveMember() {
        return document("join-member", requestFields(fieldWithPath("id").description("id"),
                        fieldWithPath("userName").type(STRING).description("이름"),
                        fieldWithPath("userId").type(STRING).description("아이디"),
                        fieldWithPath("password").type(STRING).description("패스워드"),
                        fieldWithPath("userPhone").type(STRING).description("휴대폰 번호"),
                        fieldWithPath("gender").type(STRING).description("성별"),
                        fieldWithPath("birthDay").type(STRING).description("생년월일"),
                        fieldWithPath("address").type(STRING).description("주소"),
                        fieldWithPath("email").type(STRING).description("이메일")),
                responseFields(fieldWithPath("id").description("id"),
                        fieldWithPath("userName").type(STRING).description("이름"),
                        fieldWithPath("userId").type(STRING).description("아이디"),
                        fieldWithPath("password").type(STRING).description("패스워드"),
                        fieldWithPath("userPhone").type(STRING).description("휴대폰 번호"),
                        fieldWithPath("gender").type(STRING).description("성별"),
                        fieldWithPath("birthDay").type(STRING).description("생년월일"),
                        fieldWithPath("address").type(STRING).description("주소"),
                        fieldWithPath("email").type(STRING).description("이메일")));
    }


    public static RestDocumentationResultHandler checkUserId() {
        return document("check-user-id", requestParameters(parameterWithName("userId").description("userId")),
                responseFields(fieldWithPath("result").type(BOOLEAN).description("결과(true or false)"),
                        fieldWithPath("message").type(STRING).description("메세지(success or fail)")));
    }


    public static RestDocumentationResultHandler login() {
        return document("login", requestFields(fieldWithPath("userId").description("userId"),
                        fieldWithPath("password").type(STRING).description("password")),
                responseFields(fieldWithPath("result").type(BOOLEAN).description("결과(true or false)"),
                        fieldWithPath("message").type(STRING).description("메세지(success or fail)")));
    }
}
