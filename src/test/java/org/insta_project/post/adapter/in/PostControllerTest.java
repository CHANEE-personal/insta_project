package org.insta_project.post.adapter.in;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.insta_project.member.controller.MemberController;
import org.insta_project.member.service.MemberService;
import org.insta_project.post.domain.Post;
import org.insta_project.post.service.PostService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@DisplayName("게시글 관련 api")
@ExtendWith({RestDocumentationExtension.class})
@ActiveProfiles("dev")
@AutoConfigureRestDocs
@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @MockBean
    private PostService postService;


    @BeforeEach
    public void before(WebApplicationContext was, RestDocumentationContextProvider restDocumentationContextProvider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(was)
                .apply(documentationConfiguration(restDocumentationContextProvider))
                .addFilters(new CharacterEncodingFilter("UTF-8", true)).alwaysDo(print()).build();
    }


    @Test
    @DisplayName("게시글 리스트 조회")
    void getPostsTest() throws Exception {
        List<Post> posts = new ArrayList<>();
        Post firstPost = new Post();
        firstPost.setId(1);
        firstPost.setTitle("헤라");
        firstPost.setDescription("헤라");
        firstPost.setPostUrl(
                "https://scontent-nrt1-1.cdninstagram.com/v/t51.2885-15/391427450_315366737800837_4834827310497302406_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-nrt1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=nCH8gQHAgNYAX_6SA-6&edm=AHqBGi8BAAAA&ccb=7-5&ig_cache_key=MzIxMzQzOTAyNzEzMzc2NjY0NQ%3D%3D.2-ccb7-5&oh=00_AfDGU7Pxbi83dWABa19IKVsgepiIDXnMeA_UeY6THW23KQ&oe=65317320&_nc_sid=1fce60");
        firstPost.setType("other");
        List<String> hashTags = List.of("#제니", "#꿈");
        firstPost.setHashTag(hashTags);
        firstPost.setReplyCount(10);
        firstPost.setFavoriteCount(this.createFavoriteUsers().size());
        posts.add(firstPost);

        given(postService.getPosts()).willReturn(posts);

        mockMvc.perform(get("/posts")).andDo(PostControllerDocs.getPosts()).andDo(print());
    }

    @Test
    @DisplayName("내가 작성한 게시글 리스트 조회")
    void getMyPostsTest() throws Exception {
        List<Post> posts = new ArrayList<>();
        Post firstPost = new Post();
        firstPost.setId(1);
        firstPost.setTitle("헤라");
        firstPost.setDescription("헤라");
        firstPost.setPostUrl(
                "https://scontent-nrt1-1.cdninstagram.com/v/t51.2885-15/391427450_315366737800837_4834827310497302406_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-nrt1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=nCH8gQHAgNYAX_6SA-6&edm=AHqBGi8BAAAA&ccb=7-5&ig_cache_key=MzIxMzQzOTAyNzEzMzc2NjY0NQ%3D%3D.2-ccb7-5&oh=00_AfDGU7Pxbi83dWABa19IKVsgepiIDXnMeA_UeY6THW23KQ&oe=65317320&_nc_sid=1fce60");
        firstPost.setType("me");
        List<String> hashTags = List.of("#제니", "#꿈");
        firstPost.setHashTag(hashTags);
        firstPost.setReplyCount(10);
        firstPost.setFavoriteCount(this.createFavoriteUsers().size());
        posts.add(firstPost);

        given(postService.getMyPosts()).willReturn(posts);

        mockMvc.perform(get("/posts/my-post")).andDo(PostControllerDocs.getMyPosts()).andDo(print());
    }


    private List<String> createFavoriteUsers() {
        List<String> favoriteUsers = new ArrayList<>();
        favoriteUsers.add("putriarmyteume");
        favoriteUsers.add("kansy_minjgk");
        favoriteUsers.add("tooom555");
        return favoriteUsers;
    }
}
