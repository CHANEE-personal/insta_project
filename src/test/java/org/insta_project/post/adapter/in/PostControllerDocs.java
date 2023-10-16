package org.insta_project.post.adapter.in;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import static org.springframework.restdocs.payload.JsonFieldType.ARRAY;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.beneathPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

public class PostControllerDocs {

    public static RestDocumentationResultHandler getPosts() {
        return document("get-posts", responseFields(beneathPath("posts"), fieldWithPath("id").description("게시글 ID"),
                fieldWithPath("title").type(STRING).description("게시글 제목"),
                fieldWithPath("description").type(STRING).description("게시글 내용"),
                fieldWithPath("postUrl").type(STRING).description("게시글 URL"),
                fieldWithPath("favoriteCount").description("좋아요 갯수"),
                fieldWithPath("type").type(STRING).description("작성자(other or me)"),
                fieldWithPath("hashTag[]").type(ARRAY).description("HashTag"),
                fieldWithPath("replyCount").description("댓글 갯수")));
    }

    public static RestDocumentationResultHandler getMyPosts() {
        return document("get-my-posts", responseFields(beneathPath("posts"), fieldWithPath("id").description("게시글 ID"),
                fieldWithPath("title").type(STRING).description("게시글 제목"),
                fieldWithPath("description").type(STRING).description("게시글 내용"),
                fieldWithPath("postUrl").type(STRING).description("게시글 URL"),
                fieldWithPath("favoriteCount").description("좋아요 갯수"),
                fieldWithPath("type").type(STRING).description("작성자(me)"),
                fieldWithPath("hashTag[]").type(ARRAY).description("HashTag"),
                fieldWithPath("replyCount").description("댓글 갯수")));
    }
}
