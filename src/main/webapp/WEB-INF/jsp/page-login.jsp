<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>登录页面</title>
    <style type="text/css">
        h2, p {
            text-align: center;
        }

        .login-info {
            color: red;
        }
    </style>
    <%@include file="common/head.jsp" %>
</head>
<body>
<h2>登录</h2>
<form action="/login" method="post">
    <p><input type="text" name="username" value="zzw"></p>
    <p><a class="btnLogin" href="javascript:void(0)">登录</a></p>
    <p class="login-info">${loginInfo}</p>
</form>

<script>
    $(document).ready(function () {
        $('a[class="btnLogin"]').click(function () {
            $('form').submit();
        });
    });
</script>
</body>
</html>
