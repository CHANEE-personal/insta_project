package org.insta_project.post.service;

import java.util.ArrayList;
import java.util.List;
import org.insta_project.post.domain.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        Post firstPost = new Post();
        firstPost.setId(1);
        firstPost.setTitle("헤라");
        firstPost.setDescription("헤라");
        firstPost.setPostUrl(
                "https://scontent-nrt1-1.cdninstagram.com/v/t51.2885-15/391427450_315366737800837_4834827310497302406_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-nrt1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=nCH8gQHAgNYAX_6SA-6&edm=AHqBGi8BAAAA&ccb=7-5&ig_cache_key=MzIxMzQzOTAyNzEzMzc2NjY0NQ%3D%3D.2-ccb7-5&oh=00_AfDGU7Pxbi83dWABa19IKVsgepiIDXnMeA_UeY6THW23KQ&oe=65317320&_nc_sid=1fce60");
        firstPost.setType("other");
        firstPost.setReplyCount(10);
        firstPost.setFavoriteCount(this.createFavoriteUsers().size());
        posts.add(firstPost);

        Post secondPost = new Post();
        secondPost.setId(2);
        secondPost.setTitle("Where dreams come true...\uD83D\uDD2E");
        secondPost.setDescription("Where dreams come true...\uD83D\uDD2E");
        secondPost.setPostUrl(
                "https://scontent-nrt1-1.cdninstagram.com/v/t51.2885-15/385760008_1069250717778437_2381429380843317429_n.jpg?stp=dst-jpg_e35&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDEwODAuc2RyIn0&_nc_ht=scontent-nrt1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=bp4ooEJHefEAX_8hoUJ&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzIwNjM2OTY1OTgwNTI5MTU2NQ%3D%3D.2-ccb7-5&oh=00_AfBCVqidFJ7YNN7ct6wElbMVxEe9Qi06MtGfC68e2Hfeyw&oe=653274A4&_nc_sid=ee9879");
        secondPost.setType("me");
        secondPost.setReplyCount(5);
        secondPost.setFavoriteCount(this.createSecondFavoriteUsers().size());
        posts.add(secondPost);

        Post thirdPost = new Post();
        thirdPost.setId(3);
        thirdPost.setTitle("오늘 12시에 발매되는거 알지?\n" + "내 팬들이 최고야\uD83D\uDE0D 곧 보자!");
        thirdPost.setDescription("오늘 12시에 발매되는거 알지?\\n\" + \"내 팬들이 최고야\\uD83D\\uDE0D 곧 보자!");
        thirdPost.setPostUrl(
                "https://scontent-nrt1-1.cdninstagram.com/v/t51.2885-15/338203821_172259805680783_931949003325894237_n.jpg?stp=dst-jpg_e35&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDE0NDAuc2RyIn0&_nc_ht=scontent-nrt1-1.cdninstagram.com&_nc_cat=111&_nc_ohc=niaQEm1LoVEAX_8xmSM&edm=ABmJApABAAAA&ccb=7-5&ig_cache_key=MzA2OTUyMTA0MTUxODI1MzA1OQ%3D%3D.2-ccb7-5&oh=00_AfAJxTakuZplsIr-JaVySwWu5Q6l_xFMonhL82O32hcgQg&oe=6530AEEF&_nc_sid=b41fef");
        thirdPost.setTitle("other");
        thirdPost.setReplyCount(3);
        thirdPost.setFavoriteCount(this.createThirdFavoriteUsers().size());
        posts.add(thirdPost);
        return posts;
    }


    private List<String> createFavoriteUsers() {
        List<String> favoriteUsers = new ArrayList<>();
        favoriteUsers.add("putriarmyteume");
        favoriteUsers.add("kansy_minjgk");
        favoriteUsers.add("tooom555");
        return favoriteUsers;
    }


    private List<String> createSecondFavoriteUsers() {
        List<String> favoriteUsers = new ArrayList<>();
        favoriteUsers.add("seema5930devi");
        favoriteUsers.add("dyaeich");
        return favoriteUsers;
    }


    private List<String> createThirdFavoriteUsers() {
        List<String> favoriteUsers = new ArrayList<>();
        favoriteUsers.add("rlaskfls.xx");
        favoriteUsers.add("185.161");
        return favoriteUsers;
    }


    public List<Post> getMyPosts() {
        List<Post> posts = new ArrayList<>();
        Post firstPost = new Post();
        firstPost.setId(1);
        firstPost.setTitle("Where dreams come true...\uD83D\uDD2E");
        firstPost.setDescription("Where dreams come true...\uD83D\uDD2E");
        firstPost.setPostUrl(
                "https://scontent-nrt1-1.cdninstagram.com/v/t51.2885-15/385760008_1069250717778437_2381429380843317429_n.jpg?stp=dst-jpg_e35&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDEwODAuc2RyIn0&_nc_ht=scontent-nrt1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=bp4ooEJHefEAX_8hoUJ&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzIwNjM2OTY1OTgwNTI5MTU2NQ%3D%3D.2-ccb7-5&oh=00_AfBCVqidFJ7YNN7ct6wElbMVxEe9Qi06MtGfC68e2Hfeyw&oe=653274A4&_nc_sid=ee9879");
        firstPost.setType("me");
        List<String> hashTags = new ArrayList<>();
        hashTags.add("#제니");
        hashTags.add("#꿈");
        firstPost.setHashTag(hashTags);
        firstPost.setReplyCount(5);
        firstPost.setFavoriteCount(this.createSecondFavoriteUsers().size());
        posts.add(firstPost);
        return posts;
    }
}
