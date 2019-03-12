package com.hyt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
//要注意的是，它只会在类似@ResponseBody返回json数据的时候，
// 才会返回格式化的yyyy-MM-dd HH:mm:ss时间，你直接使用System.out.println()输出的话，
// 仍然是类似“Fri Dec 01 21:05:20 CST 2017”这样的时间样式。

//公告
public class Post implements Serializable {

    private Integer postId;
    private String postTitle;
    private String postContent;

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") //发送到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //接收前台
    private Date postCreateTime;

    private Admin postAdmin;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(Date postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public Admin getPostAdmin() {
        return postAdmin;
    }

    public void setPostAdmin(Admin postAdmin) {
        this.postAdmin = postAdmin;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postCreateTime=" + postCreateTime +
                ", postAdmin=" + postAdmin +
                '}';
    }
}
