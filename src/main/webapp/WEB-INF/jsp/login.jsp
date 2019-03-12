<%--
  Created by IntelliJ IDEA.
  User: yongt
  Date: 2019/3/8
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <%--紧记：记住每一个页面都需要引入jquery库--%>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body>
<div class="container" style="width: 600px;height: 1000px">
    <div style="margin: 0 auto">
        ${ errorInfo}
    </div>
    <form action="loginForm">
    <div class="form-group" style="margin: 100px 50px">
        <label for="username" class="col-sm-2 control-label">Username</label>
        <div class="col-sm-10">
            <input type="text" name="username" class="form-control" id="username" placeholder="Username">
        </div>
    </div>

    <div class="form-group" style="padding: 80px 50px">
        <label for="password" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" name="password" class="form-control" id="password" placeholder="Password">
        </div>
    </div>

    <div class="form-group" style="margin: -20px 50px">
        <div class="col-sm-12">
            <button style="width: 100%" type="submit" class="btn btn-primary">登录</button>
        </div>
    </div>
    </form>

</div>

</body>
</html>
