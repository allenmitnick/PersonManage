package com.hyt.web;

import com.google.gson.Gson;
import com.hyt.entity.Admin;
import com.hyt.entity.Dept;
import com.hyt.entity.Post;
import com.hyt.service.DeptService;
import com.hyt.utls.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request) {

        HashMap<String, Object> map = new HashMap<>();
        List<Dept> deptList = deptService.findDepts(map);
        request.setAttribute("deptList", deptList);
        return "dept";

    }

    //    Api型 响应ajax请求
//    修改post
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String update(Dept dept){

        Integer effectNum = deptService.updateDept(dept);
        Msg msg = new Msg(0, "");
        if(1 == effectNum){
            msg.setCode(1);
        }
        return new Gson().toJson(msg);
    }

    /**
     * 获取所有部门 通过ajax返回填充下拉列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ajaxList")
    public String ajaxList(HttpServletRequest request) {

        HashMap<String, Object> map = new HashMap<>();
        List<Dept> deptList = deptService.findDepts(map);
        Msg msg = new Msg(0, "");
        if(deptList != null){
            msg.setCode(1);
            msg.setData(deptList);
        }
        return new Gson().toJson(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String delete(Integer deptId){

        Integer effectNum = deptService.removeDept(deptId);
        Msg msg = new Msg(0, "ok");
        if(1 == effectNum){
            msg.setCode(1);
        }
        return new Gson().toJson(msg);
    }

    @RequestMapping(value = "/deptAdd", produces = "application/json; charset=utf-8")
    public String deptAdd(){

        return "deptAdd";
    }

    @RequestMapping(value = "/deptAddForm", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String postAddForm(Dept dept){

        Integer effectNum = deptService.addDept(dept);
        return "deptAdd";

    }




}
