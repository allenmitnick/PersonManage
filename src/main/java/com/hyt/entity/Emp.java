package com.hyt.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//员工
public class Emp implements Serializable {

    private Integer empId;
    private String empName;
    private String sex;
    private String phone;
    private String email;
    private String address;
    private String education;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    // 部门
    private Dept empDept;
    // 职位
    private Pos empPos;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Dept getEmpDept() {
        return empDept;
    }

    public void setEmpDept(Dept empDept) {
        this.empDept = empDept;
    }

    public Pos getEmpPos() {
        return empPos;
    }

    public void setEmpPos(Pos empPos) {
        this.empPos = empPos;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", birthday=" + birthday +
                ", empDept=" + empDept +
                ", empPos=" + empPos +
                '}';
    }
}
