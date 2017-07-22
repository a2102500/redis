<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/14
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=0.8">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 登陆</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="from-group">
    <h1  style="text-align: center">欢迎登陆技能树</h1>
    <hr/>
    <form:form action="login" method="post"  reole="form">
    <div class="form-group">
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" placeholder="请输入用户名"/>
    </div>
    <div class="form-group">
        <label for="password">登陆密码:</label>
        <input type="text" id="password" name="password" placeholder="请输入密码" />
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-sm btn-success">登陆</button>
    </div>
    </form:form>
    <font color="red">没有账号？</font>
    <br />
    <a href="regist">请注册</a>

    <%--<form:form action="/student/loginto" method="post" commandName="stu"  reole="form">--%>
    <%--<div class="form-group">--%>
    <%--<label for="stu_name" class="col-sm-2 control-label">用户名</label>--%>
    <%--<div class="col-sm-10">--%>
    <%--<input type="stu_name" class="form-control" id="stu_name" placeholder="请输入您的用户名">--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
    <%--<label for="stu_pwd" class="col-sm-2 control-label">密码</label>--%>
    <%--<div class="col-sm-10">--%>
    <%--<input type="stu_pwd" class="form-control" id="stu_pwd" placeholder="请输入您的登陆密码">--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
    <%--<div class="col-sm-offset-2 col-sm-10">--%>
    <%--<div class="checkbox">--%>
    <%--<label>--%>
    <%--<input type="checkbox">记住密码--%>
    <%--</label>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
    <%--<div class="col-sm-offset-2 col-sm-10">--%>
    <%--<button type="submit" class="btn btn-default">登陆</button>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</form:form>--%>
</body>
</html>
