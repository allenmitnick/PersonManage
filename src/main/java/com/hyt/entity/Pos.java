package com.hyt.entity;

import java.io.Serializable;
import java.util.List;

//职位
public class Pos implements Serializable {

    private Integer posId;
    private String posName;
    private String posDescription;

    private List<Emp> empList;

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getPosDescription() {
        return posDescription;
    }

    public void setPosDescription(String posDescription) {
        this.posDescription = posDescription;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Pos{" +
                "posId=" + posId +
                ", posName='" + posName + '\'' +
                ", posDescription='" + posDescription + '\'' +
                ", empList=" + empList +
                '}';
    }
}
