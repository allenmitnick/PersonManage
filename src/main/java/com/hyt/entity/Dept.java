package com.hyt.entity;

import java.io.Serializable;
import java.util.List;

//部门
public class Dept implements Serializable {

    // 部门编号
    private Integer deptId;
    // 名称
    private String deptName;
    // 描述
    private String deptDescription;

    private List<Emp> empList;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptDescription='" + deptDescription + '\'' +
                ", empList=" + empList +
                '}';
    }
}
