package org.insta_project.post.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private long id;
    private String title;
    private String description;
    private List<String> hashTag = new ArrayList<>();
    private String postUrl;
    private int favoriteCount;
    private String type;
    private int replyCount;
}
