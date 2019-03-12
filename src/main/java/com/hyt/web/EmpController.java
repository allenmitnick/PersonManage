package com.hyt.web;

import com.hyt.entity.Dept;
import com.hyt.entity.Emp;
import com.hyt.entity.Pos;
import com.hyt.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request){

        HashMap<String, Object> map = new HashMap<>();
        List<Emp> empList = empService.findEmps(map);
        request.setAttribute("empList", empList);
        return "emp";
    }

    @RequestMapping(value = "/empAdd", produces = "application/json; charset=utf-8")
    public String deptAdd(){

        return "empAdd";
    }

    @RequestMapping(value = "/empAddForm", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String postAddForm(Emp emp,String deptId,String posId){

        Dept empDept = new Dept();
        empDept.setDeptId(Integer.parseInt(deptId));
        Pos empPos = new Pos();
        empPos.setPosId(Integer.parseInt(posId));

        emp.setEmpDept(empDept);
        emp.setEmpPos(empPos);

        Integer effectNum = empService.addEmp(emp);
        return "empAdd";


    }
}
