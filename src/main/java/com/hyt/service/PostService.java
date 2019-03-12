package com.hyt.service;


import com.hyt.entity.Post;

import java.util.List;
import java.util.Map;

public interface PostService {

    /**
     * 添加通知
     * @param post
     * @return
     */
    public Integer addPost(Post post);

    /**
     * 修改通知
     * @param post
     * @return
     */
    public Integer updatePost(Post post);

    /**
     * 删除通知
     * @param postId
     * @return
     */
    public Integer removePost(Integer postId);

    /**
     * 根据条件查询通知数 【没有条件或者通知id】
     * @param map
     * @return
     */
    public Integer getCount(Map<String, Object> map);

    /**
     * 根据条件职位出通知 【没有条件或者通知ID 或者通知name】
     * @param map
     * @return
     */
    public List<Post> findPosts(Map<String, Object> map);

    /**
     * 查询最新的一条通知
     * @return
     */
    public Post findLastedPost();
}
