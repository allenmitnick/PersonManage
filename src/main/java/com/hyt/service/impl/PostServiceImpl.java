package com.hyt.service.impl;

import com.hyt.dao.PostDao;
import com.hyt.entity.Post;
import com.hyt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public Integer addPost(Post post) {
        return postDao.insertPost(post);
    }

    @Override
    public Integer updatePost(Post post) {
        return postDao.updatePost(post);
    }

    @Override
    public Integer removePost(Integer postId) {
        return postDao.deletePost(postId);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return postDao.getCount(map);
    }

    @Override
    public List<Post> findPosts(Map<String, Object> map) {
        return postDao.findPosts(map);
    }

    @Override
    public Post findLastedPost() {
        return postDao.findLastedPost();
    }
}
