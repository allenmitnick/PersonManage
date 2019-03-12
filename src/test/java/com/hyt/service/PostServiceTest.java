package com.hyt.service;

import com.hyt.BaseTest;
import com.hyt.entity.Post;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class PostServiceTest extends BaseTest {
    @Autowired
    private PostService postService;

    @Test
    public void testQueryPost(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("postId", 1);
        List<Post> postList = postService.findPosts(map);
        for(Post post:postList){
            System.out.println(post);
        }
    }
}
