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
    <title>这是借书主页</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <%@include file="../common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="box"><h1>图书管理员主页</h1></div>
    <div class="flexible-box">
        <div id="form1">
            <form id="cardno-form">
                <table>
                    <tr>
                        <th colspan="2">请输入以下信息:</th>
                    </tr>
                    <tr>
                        <td><label for="cardno">借阅卡号：</label></td>
                        <td><input type="text" name="cardno" id="cardno"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button id="btnSubmit">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>

<script>
    $(document).ready(function () {
        $("button#btnSubmit").click(function () {
            var $this = $(this);
            $this.attr("disabled", true);
            $.post("/mgr/vrfyusr",
                $("form#cardno-form").serialize(),
                function (res) {
                    if (res.err_code == 0) {
                        window.location.assign("/mgr/" + res.data.cardno + "/loanview2");
                        return;
                    } else {
                        alert("Error: " + res.err_msg);
                    }
                    $this.attr("disabled", false);
                });
        });
    });
</script>
</body>
</html>
