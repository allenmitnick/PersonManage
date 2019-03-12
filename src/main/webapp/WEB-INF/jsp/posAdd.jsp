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
    <title>添加部门</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <%--紧记：记住每一个页面都需要引入jquery库--%>
    <script type="text/javascript" src="../js/jquery.min.js"></script>

</head>
<body>

<div class="container">

    <form method="post" action="${ pageContext.request.contextPath}/pos/posAddForm">


        <div class="form-group" style="margin-top: 50px">
            <input type="text" class="form-control" name="posName" placeholder="职位名称">
        </div>


        <div class="form-group">
            <textarea id="myEditor" class="form-control" rows="8" name="posDescription" placeholder="职位描述"></textarea>
        </div>

        <div class="row">
            <div class="col-md-8"></div>
            <div class="col-md-4">
                <button style="width: 100%" type="submit" class="btn btn-primary">提交</button>
            </div>
        </div>

    </form>
</div>


</body>
</html>
