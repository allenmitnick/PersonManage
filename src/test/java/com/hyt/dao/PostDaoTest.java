package com.hyt.dao;

import com.hyt.BaseTest;
import com.hyt.entity.Dept;
import com.hyt.entity.Post;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PostDaoTest extends BaseTest {

    @Autowired
    private PostDao postDao;

    /**
     * 增加
     */
    @Test
    public void insertPost() throws Exception{

        Post post = new Post();
        post.setPostTitle("奖励通知");
        post.setPostContent("奖励胡永涛1000元");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse("2019-3-1 7:1:32");
        post.setPostCreateTime(date);

        Integer effectNum = postDao.insertPost(post);
        System.out.println("effectNum:" + effectNum);
    }

    /**
     * 删除
     */
    @Test
    public void deletePost(){

        Integer effectNum = postDao.deletePost(2);
        System.out.println("effectNum:" + effectNum);
    }

    /**
     * 更新
     */
    @Test
    public void updatePost(){
        Post post = new Post();
        post.setPostId(1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {

            date = df.parse("2019-3-1 7:1:32");
        }catch (Exception e){

        }
        post.setPostCreateTime(date);
        Integer effectNum = postDao.updatePost(post);
        System.out.println("effectNum:" + effectNum);
    }

    @Test
    public void testQueryPost(){

        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("deptName","销售");
        map.put("postId", 1);
        List<Post> postList = postDao.findPosts(map);
        for(Post post:postList){
            System.out.println(post);
        }
    }

    @Test
    public void testGetCount(){

        Integer count = postDao.getCount(new HashMap<String, Object>());
        System.out.println("count:" +count);
    }


}
