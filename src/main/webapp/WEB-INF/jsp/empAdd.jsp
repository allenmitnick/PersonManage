<%--
  Created by IntelliJ IDEA.
  User: yongt
  Date: 2019/3/5
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>添加员工</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <%--紧记：记住每一个页面都需要引入jquery库--%>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <style type="text/css">
        .inputText{
            margin-top: 30px;
        }
    </style>

</head>
<body>

<div class="container">

    <form method="post" action="${ pageContext.request.contextPath}/emp/empAddForm">


        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" name="empId" class="form-control inputText" id="emp_id" placeholder="员工编号">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" name="empName" class="form-control inputText" id="emp_name" placeholder="员工姓名">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" name="sex" class="form-control inputText" id="sex" placeholder="员工性别">
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" name="phone" class="form-control inputText" id="phone" placeholder="员工手机号">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" name="email" class="form-control inputText" id="email" placeholder="员工邮箱">
            </div>

        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" name="address" class="form-control inputText" id="address" placeholder="员工住址">
            </div>

        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" name="education" class="form-control inputText" id="education" placeholder="教育程度">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="date" name="birthday" class="form-control inputText" id="birthday" placeholder="出生日期">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <select id="deptSelect" name="deptId" class="form-control inputText">
                    <option value='0'>----部门---</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <select id="posSelect" name="posId" class="form-control inputText">
                    <option value='0'>----职位---</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <button style="width:100%; margin-top: 40px" type="submit" class="btn btn-primary">提交</button>
            </div>
        </div>

    </form>
</div>

<script type="text/javascript">
    $(function(){
       ajaxLoadDept();
       ajaxLoadPos();

    });

    function ajaxLoadDept(){

        $.ajax({
            url: '${pageContext.request.contextPath}/dept/ajaxList',
            dataType: "json",
            type: "post",
            success: function (msg) {
                // 处理正确的返回数据
                if (msg.code == 1) {
                    $.each(msg.data, function(index, deptObj){
                        // alert(deptObj['deptId']);
                        // alert(deptObj['deptName']);
                        $("#deptSelect").append("<option value="+ deptObj['deptId']+ ">"+ deptObj['deptName']+ "</option>");
                    });
                }

            }, error: function () {
                alert("数据传输错误！");
            }
        })
    }

    function ajaxLoadPos(){

        $.ajax({
            url: '${pageContext.request.contextPath}/pos/ajaxList',
            dataType: "json",
            type: "post",
            success: function (msg) {
                // 处理正确的返回数据
                if (msg.code == 1) {
                    $.each(msg.data, function(index, deptObj){
                        // alert(deptObj['deptId']);
                        // alert(deptObj['deptName']);
                        $("#posSelect").append("<option value="+ deptObj['posId']+ ">"+ deptObj['posName']+ "</option>");
                    });
                }

            }, error: function () {
                alert("数据传输错误！");
            }
        })
    }


</script>


</body>
</html>
