<%--
  Created by IntelliJ IDEA.
  User: thick
  Date: 2018/10/26
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <%@include file="../common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="box"><h2>添加用户</h2></div>
    <div>
        <div class="flexible-box">
            <form id="userSubmit">
                <table>
                    <tr>
                        <th>姓名</th>
                        <th>昵称</th>
                        <th>密码</th>
                    </tr>
                    <tr>
                        <td><input name="username" type="text" placeholder="your name" required/></td>
                        <td><input name="nickname" type="text" placeholder="your nickname" required/></td>
                        <td><input name="password" type="password" placeholder="your password" required></td>
                    </tr>
                    <tr>
                        <td colspan="3" style="text-align: center"><input type="submit" value="提交"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#userSubmit').submit(function (e) {
            e.preventDefault();

            $.post('/index/submit',
                {
                    username: $("input[name='username']").val(),
                    nickname: $("input[name='nickname']").val(),
                    password: $("input[name='password']").val()
                },
                function (response, status) {
                    if (response.err_code == 0) {
                        alert("用户添加成功!");
                        window.location.assign("/index");
                        return;
                    } else {
                        alert("Failed: " + response.err_msg);
                        return;
                    }
                }
            )
            ;
        });
    });
</script>
</body>
</html>


















