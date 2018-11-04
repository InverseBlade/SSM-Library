<%--
  Created by IntelliJ IDEA.
  User: thick
  Date: 2018/10/25
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>已注册用户</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <%@include file="../common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="box"><h2>已注册用户</h2></div>
    <div class="flexible-box">
        <table>
            <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>昵称</th>
                <th>密码</th>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td><a class="link-detail">${user.id}</a></td>
                    <td>${user.userName}</td>
                    <td>${user.nickName}</td>
                    <td>${user.passwd}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <p>
        <button onclick="window.location.assign('/index/publish')">去注册</button>
    </p>
</div>

<script src="/static/js/user-index.js"></script>
</body>
</html>
