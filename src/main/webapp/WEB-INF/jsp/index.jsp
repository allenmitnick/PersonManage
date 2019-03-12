<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

<head>
    <%--easyui的css 和 js文件--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <%--自己需要的css 和 js文件    --%>
    <link rel="stylesheet" type="text/css" href="../css/admin/index.css">

</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'人事管理系统',split:true" style="height:65px;">
    <div style="float: right;margin-right: 10px">
        当前管理员：${ currentAdmin.username}
    </div>
</div>
<div data-options="region:'west',title:'菜单',split:true" style="width:210px;">

    <%--此处显示的是系统菜单--%>
    <div id="menu" class="easyui-accordion" data-options="" style="height:300px;">
        <div title="部门管理" data-options="iconCls:'icon-reload' ">
            <ul>
                <li><a href="#" onclick="addTab($(this).text(), '${pageContext.request.contextPath}/dept/list')">部门列表</a></li>
                <li><a href="#" onclick="addTab($(this).text(), '${pageContext.request.contextPath}/dept/deptAdd')">添加部门</a></li>
            </ul>
        </div>

        <div title="职位管理" data-options="iconCls:'icon-reload' ">
            <ul>
                <li><a href="#" onclick="addTab($(this).text(), '${pageContext.request.contextPath}/pos/list')">职位列表</a></li>
                <li><a href="#" onclick="addTab($(this).text(), '${pageContext.request.contextPath}/pos/posAdd')">添加职位</a></li>
            </ul>
        </div>

        <div title="员工管理" data-options="iconCls:'icon-reload' ">
            <ul>
                <li><a href="#" onclick="addTab($(this).text(), '${pageContext.request.contextPath}/emp/list')">员工列表</a></li>
                <li><a href="#" onclick="addTab($(this).text(), '${pageContext.request.contextPath}/emp/empAdd')">添加员工</a></li>
            </ul>
        </div>



        <div title="公告管理" data-options="iconCls:'icon-reload' ">
            <ul>
                <li><a href="#"
                       onclick="addTab($(this).text(), '${pageContext.request.contextPath}/post/list')">公告列表</a></li>
                <li><a href="#"
                       onclick="addTab($(this).text(), '${pageContext.request.contextPath}/post/postAdd')">添加公告</a></li>
            </ul>
        </div>
    </div>

</div>
<div data-options="region:'center',title:''" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs">
        <div class="container" title="首页" style="padding:20px;display:none;">

            <div class="row" style="text-align: center">

                <h1>${ lastedPost.postTitle}</h1>
            </div>
            <div class="row">
                <div class="col-md-7"></div>
                <div class="col-md-2">
                    作者：<span>${ lastedPost.postAdmin.username}</span>
                </div>
                <div class="col-md-3">
                    发布时间：<fmt:formatDate value="${ lastedPost.postCreateTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
                </div>

            </div>

            <div class="lead"> ${ lastedPost.postContent}</div>
        </div>

    </div>
</div>

<script>


    // 点击菜单栏，添加选项卡
    function addTab(title, url) {

        if ($('#tabs').tabs("exists", title)) {
            $('#tabs').tabs("select", title)
        } else {
            var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
            $('#tabs').tabs('add', {
                title: title,
                content: content,
                closable: true
            });
        }
    }


</script>


</body>
</html>
