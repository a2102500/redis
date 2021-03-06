<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/15
  Time: 0:30
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
    <title>SpringMVC修改学员信息</title>
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
    <h1  style="text-align: center">修改学员信息</h1>
    <hr/>
    <form:form action="/task10/update" method="post" commandName="stu" reole="form">
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名"/>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码"/>
        </div>
        <div class="form-group">
            <label for="hope">期望:</label>
            <input type="text" class="form-control" id="hope" name="hope" placeholder="请输入期望"/>
        </div><div class="form-group">
        <label for="course">课程:</label>
        <input type="text" class="form-control" id="course" name="course" placeholder="请输入课程"/>
    </div>
        <div class="form-group">
            <label for="date">日期:</label>
            <input type="text" class="form-control" id="date" name="date" placeholder="请输入日期"/>
        </div>
        <div class="form-group">
            <label for="school">学校:</label>
            <input type="text" class="form-control" id="school" name="school" placeholder="请输入学校"/>
        </div>
        <div class="form-group">
            <label for="qq">QQ:</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入qq号"/>
        </div>
        <div class="form-group">
            <label for="yinjian">引荐师兄:</label>
            <input type="text" class="form-control" id="yinjian" name="yinjian" placeholder="请输入引荐师兄"/>
        </div>
        <div class="form-group">
            <label for="shenhe">审核师兄:</label>
            <input type="text" class="form-control" id="shenhe" name="shenhe" placeholder="请输入审核师兄"/>
        </div>
        <div class="form-group">
            <label for="phone">手机:</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号"/>
        </div>
        <div class="form-group">
            <label for="company">公司:</label>
            <input type="text" class="form-control" id="company" name="company" placeholder="请输入公司名称"/>
        </div>
        <%--<div class="form-group">--%>
        <%--<label for="creat_at">创建时间:</label>--%>
        <%--<input type="hidden" class="form-control" id="creat_at" name="creat_at" placeholder="系统录入创建时间"/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
        <%--<label for="update_at">修改时间:</label>--%>
        <%--<input type="hidden" class="form-control" id="update_at" name="updaet_at" placeholder="系统录入修改时间"/>--%>
        <%--</div>--%>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>
</div>
</body>
</html>
