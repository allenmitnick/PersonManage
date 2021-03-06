<%--
  Created by IntelliJ IDEA.
  User: yongt
  Date: 2019/3/3
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>部门列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <%--紧记：记住每一个页面都需要引入jquery库--%>
    <script type="text/javascript" src="../js/jquery.min.js"></script>


</head>
<body>

<div class="container">

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-11">
            <%--tr代表一行 为for循环的一个单位--%>
            <table class="table">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>部门名称</th>
                    <th>部门描述</th>
                </tr>
                </thead>

                <tbody>


                <c:forEach items="${ deptList}" var="dept">
                    <tr>
                        <td>${dept.deptId}</td>
                        <td>${dept.deptName}</td>
                        <td>${dept.deptDescription}</td>


                            <%--传参如果是字符串类型必须要加单引号--%>
                        <td>
                            <button type="button" class="btn btn-primary" onclick="updateDept(${ dept.deptId}, '${ dept.deptName}', '${ dept.deptDescription}') ">修改
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger" onclick="deleteDept(${ dept.deptId}) ">删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4 class="modal-title">修改部门</h4>
                </div>

                <div class="modal-body">
                    <%--模态框主体内容--%>
                    <form class="form-horizontal" id="updateForm">

                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" id="deptName"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-12">
                                <textarea class="form-control"  rows="3" id="deptDescription" ></textarea>
                            </div>
                        </div>


                        <div class="modal-footer">
                            <button type="button" class="btn btn-default update" data-dismiss="modal">关闭</button>
                            <button id="postSubmit" type="button" class="btn btn-primary update">提交更改</button>
                        </div>
                    </form>
                    <%--模态框主体内容--%>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>


    </div>
</div>
<script>
        // UE.getEditor('postContent');

        function updateDept(deptId, deptName, deptDescription) {

            // 1.显示模态对话框
            $('#myModal').modal("show");

            // 2.给对话框里赋值
            $('#deptName').attr("value", deptName);
            $('#deptDescription').val(deptDescription);
            // 3.点击提交更改发起ajax请求
            $('#postSubmit').click(function (){

                deptName = $('#deptName').val();
                deptDescription = $('#deptDescription').val();

                sendUpdateAjax(deptId, deptName, deptDescription);
                // 发动ajax请求后 隐藏模态对话框
                $('#myModal').modal("hide");


            })


        }
        function sendUpdateAjax(deptId, deptName, deptDescription) {

            url = '${pageContext.request.contextPath}/dept/update';
            data = {
                "deptId": deptId,
                "deptName": deptName,
                "deptDescription": deptDescription
            };

            $.ajax({
                url: url,
                data: data,
                dataType: "json",
                type: "post",
                success: function (msg) {

                    // 处理正确的返回数据
                    if (msg.code == 1) {
                        parent.location.reload();
                    }


                }, error: function () {
                    alert("数据传输错误！");
                }
            })
        }

       function deleteDept(deptId) {

            url = '${pageContext.request.contextPath}/dept/delete';
            data = {
                "deptId": deptId
            };

            $.ajax({
                url: url,
                data: data,
                dataType: "json",
                type: "post",
                success: function (msg) {

                    // 处理正确的返回数据
                    if (msg.code == 1) {
                        parent.location.reload();
                    }

                }, error: function () {
                    alert("数据传输错误！");
                }
            })

        }



</script>


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <%--<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>--%>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
