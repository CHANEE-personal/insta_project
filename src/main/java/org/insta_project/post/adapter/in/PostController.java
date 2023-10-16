package org.insta_project.post.adapter.in;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.insta_project.post.domain.Post;
import org.insta_project.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping
    public ResponseEntity<Map<String, List<Post>>> getPosts() {
        Map<String, List<Post>> result = new HashMap<>();
        result.put("posts", postService.getPosts());
        return ResponseEntity.ok(result);
    }


    @GetMapping("/my-post")
    public ResponseEntity<Map<String, List<Post>>> getMyPosts() {
        Map<String, List<Post>> result = new HashMap<>();
        result.put("posts", postService.getMyPosts());
        return ResponseEntity.ok(result);
    }
}
