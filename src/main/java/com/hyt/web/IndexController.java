package com.hyt.web;

import com.hyt.entity.Admin;
import com.hyt.entity.Post;
import com.hyt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class IndexController {


    @Autowired
    private PostService postService;

    @RequestMapping(value = "")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Admin currentAdmin = (Admin) request.getSession().getAttribute("currentAdmin");
        System.out.println(currentAdmin);
        if (currentAdmin != null) {
            return "index";
        }
        response.sendRedirect(request.getContextPath());
        return null;

    }




}
