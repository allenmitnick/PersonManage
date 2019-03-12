package com.hyt.web;

import com.hyt.entity.Admin;
import com.hyt.entity.Post;
import com.hyt.service.AdminService;
import com.hyt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private PostService postService;

    @RequestMapping(value = "")
    public String login(){
        return "login";
    }


    @RequestMapping(value = "loginForm")
    public void login(Admin admin, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        System.out.println(admin);
        Admin currentAdmin = adminService.login(admin);
        if(currentAdmin != null){

            Post lastedPost = postService.findLastedPost();
            System.out.println(lastedPost);
            request.getSession().setAttribute("currentAdmin", currentAdmin);
            response.sendRedirect(request.getContextPath() + "/admin/");
            request.getSession().setAttribute("lastedPost", lastedPost);

        }else{
            request.setAttribute("errorInfo","用户名或者密码错误！");

            request.getRequestDispatcher("").forward(request,response);
        }

    }
}
