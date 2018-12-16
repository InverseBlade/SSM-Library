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
    <title>这是还书主页</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <%@include file="../common/head.jsp" %>
    <style type="text/css">
        .loan-affirm-info {
            display: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="box"><h1>图书管理员页面</h1></div>
    <div class="flexible-box">
        <div id="form2">
            <form id="item-form" method="post">
                <table>
                    <tr>
                        <th colspan="2">请输归还物品信息:</th>
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
            </form>
        </div>
    </div>
    <div class="loan-affirm-info">
        <div class="flexible-box">
            <p><strong>借阅者：</strong><span></span></p>
            <p><strong>书目编号：</strong><span></span></p>
            <p><strong>书目名称：</strong><span></span></p>
            <p><strong>借阅时间：</strong><span></span></p>
            <a href="javascript:void(0);">确认归还</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="javascript:void(0);">重新输入</a>
        </div>
        <form method="post" action="/mgr/returnitem">
            <input name="cardno" type="hidden" value="">
            <input name="librarycode" type="hidden" value="">
        </form>
    </div>
</div>
<%@include file="../common/footer.jsp" %>

<script>
    $(document).ready(function () {
        var lock = false;
        var $divAffirmInfo = $('div[class="loan-affirm-info"]');
        var cardno, libraryCode;

        var $form = $('form#item-form');
        $form.attr('action', '/mgr/returnitem');
        //验证项目编号表单事件
        $form.submit(function (e) {
            e.preventDefault();
            $('form#item-form input[type="submit"]').attr("disabled", true);
            $.post(
                '/mgr/loanaffirminfo',
                $form.serialize(),
                function (res, status) {
                    if (res.err_code == 0) {
                        var data = res.data;
                        var spanArray = $divAffirmInfo.find("p span");
                        spanArray.eq(0).text(data['cardno']);
                        spanArray.eq(1).text(data['libraryCode']);
                        spanArray.eq(2).text(data['titleName']);
                        spanArray.eq(3).text(data['loan'].loanDate);
                        cardno = data['cardno'];
                        libraryCode = data['libraryCode'];
                        $('div[class="loan-affirm-info"]').removeClass();
                    } else {
                        alert("错误：" + res.err_msg + "！");
                        $('form#item-form input[type="submit"]').attr("disabled", false);
                        return;
                    }
                }
            );
        });
        //确认返还
        $('div[class="loan-affirm-info"] a').eq(0).click(function () {
            if (lock) return;
            lock = !lock;
            //
            var form = $divAffirmInfo.find("form").eq(0).get(0);
            form.elements['cardno'].value = cardno;
            form.elements['librarycode'].value = libraryCode;
            form.submit();
        });
        //重新填写
        $('div[class="loan-affirm-info"] a').eq(1).click(function () {
            $('form#item-form input[type="submit"]').attr("disabled", false);
            $divAffirmInfo.addClass("loan-affirm-info");
        });

    });
</script>
</body>
</html>
