<%--
  Created by IntelliJ IDEA.
  User: thick
  Date: 2018/11/8
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <%@include file="../common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="box"><h1>${title}</h1></div>
    <div class="flexible-box">
        <p>${result}</p>
        <p>${error_msg}</p>
    </div>
</div>
<h4 style="text-align: center"><a href="">返回上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/mgr">回到首页</a>
</h4>
<script>
    window.onload = function (ev) {
        $('a').eq(0).attr('href', document.referrer)
    };
</script>
</body>
</html>
