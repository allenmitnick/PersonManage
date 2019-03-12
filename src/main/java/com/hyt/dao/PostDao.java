package com.hyt.dao;

import com.hyt.entity.Admin;
import com.hyt.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PostDao {
    /**
     * 添加通知
     *
     * @param post
     * @return
     */
    public Integer insertPost(Post post);

    /**
     * 修改通知
     *
     * @param post
     * @return
     */
    public Integer updatePost(Post post);

    /**
     * 删除通知（根据通知id）
     *
     * @param postId
     * @return
     */
    public Integer deletePost(Integer postId);


    /**
     * 根据条件查询通知
     *
     * @param map
     * @return
     */
    public List<Post> findPosts(@Param("params") Map<String, Object> map);

    /**
     * 根据条件查询通知数
     *
     * @param map
     * @return
     */
    public Integer getCount(@Param("params") Map<String, Object> map);

    /**
     * 返回最新的一条通知
     * @return
     */
    public Post findLastedPost();
}
