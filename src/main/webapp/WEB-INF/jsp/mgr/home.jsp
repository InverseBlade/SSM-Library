<%--
  Created by IntelliJ IDEA.
  User: thick
  Date: 2018/12/9
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>图书管理员主页</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <%@include file="../common/head.jsp" %>
</head>
<body>
<div class="container">
    <h1>图书管理员主页</h1>
    <div class="flexible-box">
        <h4>功能模块列表：</h4>
        <table>
            <tr>
                <td><a href="/mgr/loan/checkcardno">借出书目</a></td>
                <td><a href="/mgr/returnview">返还书目</a></td>
                <td><a href="#">取消预定</a></td>
            </tr>
            <tr>
                <td><a href="#">处理赔偿</a></td>
            </tr>
        </table>
    </div>
</div>
<h4 style="text-align: center"><a href="/logout">退出登录</a></h4>
</body>
</html>

