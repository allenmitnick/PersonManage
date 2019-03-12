package com.hyt.web;

import com.google.gson.Gson;
import com.hyt.entity.Dept;
import com.hyt.entity.Pos;
import com.hyt.service.DeptService;
import com.hyt.service.PosService;
import com.hyt.service.PostService;
import com.hyt.utls.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/pos")
public class PosController {

    @Autowired
    private PosService posService;

    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request) {

        HashMap<String, Object> map = new HashMap<>();
        List<Pos> posList = posService.findPoss(map);
        request.setAttribute("posList", posList);
        return "pos";

    }

    //    Api型 响应ajax请求
//    修改post
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String update(Pos pos){

        Integer effectNum = posService.updatePos(pos);
        Msg msg = new Msg(0, "");
        if(1 == effectNum){
            msg.setCode(1);
        }
        return new Gson().toJson(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String delete(Integer posId){

        Integer effectNum = posService.removePos(posId);
        Msg msg = new Msg(0, "ok");
        if(1 == effectNum){
            msg.setCode(1);
        }
        return new Gson().toJson(msg);
    }

    @RequestMapping(value = "/posAdd", produces = "application/json; charset=utf-8")
    public String deptAdd(){

        return "posAdd";
    }

    @RequestMapping(value = "/posAddForm", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String postAddForm(Pos pos){

        Integer effectNum = posService.addPos(pos);
        return "posAdd";


    }

    @ResponseBody
    @RequestMapping(value = "/ajaxList", method = RequestMethod.POST)
    public String ajaxList(HttpServletRequest request) {

        HashMap<String, Object> map = new HashMap<>();
        List<Pos> posList = posService.findPoss(map);
        Msg msg = new Msg(0, "");
        if(posList != null){
            msg.setCode(1);
            msg.setData(posList);
        }
        return new Gson().toJson(msg);

    }




}
