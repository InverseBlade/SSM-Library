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
        <div id="form2">
            <form id="item-form" method="post">
                <table>
                    <tr>
                        <td>当前借阅者:</td>
                        <td id="current-borrower">${cardno}</td>
                    </tr>
                    <tr>
                        <th colspan="2">请输入物品信息:</th>
                    </tr>
                    <tr>
                        <td><label for="item">物品编号：</label></td>
                        <td><input type="text" name="librarycode" id="item" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="提交">
                        </td>
                    </tr>
                </table>
                <input name="cardno" id="cardno-sure" type="hidden" value="${cardno}"/>
            </form>
            <div class="flexible-box">
                <h3>该借阅者已借阅项目</h3>
                <table>
                    <tr>
                        <th>编号</th>
                        <th>书名</th>
                        <th>已借数目</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${borrowerCustom.loanCustoms}" var="item">
                        <tr>
                            <td>${item.itemCustom.libraryCode}</td>
                            <td>${item.itemCustom.title.name}</td>
                            <td>${item.itemCustom.title.borrowedNumber}</td>
                            <td>
                                <form method="post" action="/mgr/returnitem">
                                    <input name="cardno" type="hidden" value="${cardno}">
                                    <input name="librarycode" type="hidden" value="${item.itemCustom.libraryCode}">
                                </form>
                                <a class="return-action" href="javascript:void(0)">归还</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>

<script>
    $(document).ready(function () {
        $('form#item-form').attr("action", "/mgr/loanitem");

        $("a.return-action").click(function () {
            $(this).siblings('form').submit();
        });
    });
</script>
</body>
</html>
