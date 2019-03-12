package com.hyt.web;

import com.google.gson.Gson;
import com.hyt.entity.Admin;
import com.hyt.entity.Post;
import com.hyt.service.PostService;
import com.hyt.utls.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request){

        HashMap<String, Object> map = new HashMap<>();
        List<Post> postList = postService.findPosts(map);
        request.setAttribute("postList", postList);
        return "post";

    }

//    Api型 响应ajax请求
//    需要通过products设置响应编码，否则乱码
//    通过id查询返回post
    @ResponseBody
    @RequestMapping(value = "/getBypostId", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String getBypostId(@RequestParam("postId") String postId){

        HashMap<String, Object> map = new HashMap<>();
        map.put("postId", postId);
        List<Post> posts = postService.findPosts(map);

        Msg msg = new Msg(0, "");
        if(posts != null && posts.size() == 1){
            msg.setCode(1);
            msg.setData(posts.get(0));
        }

        return new Gson().toJson(msg);

    }

    //    Api型 响应ajax请求
//    修改post
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String update(Post post){

//        System.out.println(post);
        Integer effectNum = postService.updatePost(post);
        Msg msg = new Msg(0, "");
        if(1 == effectNum){
            msg.setCode(1);
        }
        return new Gson().toJson(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String delete(Integer postId){

        Integer effectNum = postService.removePost(postId);
        Msg msg = new Msg(0, "ok");
        if(1 == effectNum){
            msg.setCode(1);
        }
        return new Gson().toJson(msg);
    }

    @RequestMapping(value = "/postAdd", produces = "application/json; charset=utf-8")
    public String postAdd(HttpServletRequest request){

        return "postAdd";
    }


    @RequestMapping(value = "/postAddForm", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String postAddForm(Post post, HttpServletRequest request){


//        System.out.println("已经收到表单");
//        System.out.println(post);
        post.setPostCreateTime(new Date());
//        System.out.println(post);
        Admin currentAdmin = (Admin) request.getSession().getAttribute("currentAdmin");
        if(currentAdmin != null){
            post.setPostAdmin(currentAdmin);
        }
        Integer effectNum = postService.addPost(post);
        return "postAdd";
    }


}
