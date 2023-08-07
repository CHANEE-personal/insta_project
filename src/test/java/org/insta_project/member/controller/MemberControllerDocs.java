package org.insta_project.member.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

public class MemberControllerDocs {

    public static RestDocumentationResultHandler saveMember() {
        return document("join-member",
                requestFields(
                        fieldWithPath("id").description("id"),
                        fieldWithPath("userName").type(STRING).description("이름"),
                        fieldWithPath("userId").type(STRING).description("아이디"),
                        fieldWithPath("password").type(STRING).description("패스워드"),
                        fieldWithPath("userPhone").type(STRING).description("휴대폰 번호"),
                        fieldWithPath("sex").type(STRING).description("성별"),
                        fieldWithPath("birthDay").type(STRING).description("생년월일"),
                        fieldWithPath("address").type(STRING).description("주소"),
                        fieldWithPath("email").type(STRING).description("이메일")),
                responseFields(
                        fieldWithPath("id").description("id"),
                        fieldWithPath("userName").type(STRING).description("이름"),
                        fieldWithPath("userId").type(STRING).description("아이디"),
                        fieldWithPath("password").type(STRING).description("패스워드"),
                        fieldWithPath("userPhone").type(STRING).description("휴대폰 번호"),
                        fieldWithPath("sex").type(STRING).description("성별"),
                        fieldWithPath("birthDay").type(STRING).description("생년월일"),
                        fieldWithPath("address").type(STRING).description("주소"),
                        fieldWithPath("email").type(STRING).description("이메일")));
    }
}
