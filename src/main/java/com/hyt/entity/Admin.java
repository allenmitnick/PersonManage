package com.hyt.entity;

import java.io.Serializable;
import java.util.List;

//管理员
public class Admin implements Serializable {

    // 管理员编号
    private Integer adminId;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 管理员角色
    private String roleName;

    private List<Post> postList;

    public Admin() {
    }

    public Admin(String username, String password, String roleName) {

        this.username = username;
        this.password = password;
        this.roleName = roleName;
    }

    public Admin(String username, String password, String roleName, List<Post> postList) {

        this.username = username;
        this.password = password;
        this.roleName = roleName;
        this.postList = postList;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleName='" + roleName + '\'' +
                ", postList=" + postList +
                '}';
    }
}
