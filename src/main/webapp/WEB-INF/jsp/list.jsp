<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/14
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GB2312">
    <title>学员信息列表</title>
</head>
<body style="align-content: center">
<%--
<h1 style="text-align: center">学员信息列表<a href="/task10/list">查找</a></h1>
--%>
<table width="100%" border=1px  cellpadding="1" cellspacing="1">
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>密码</th>
        <th>愿景</th>
        <th>课程</th>
        <th>日期</th>
        <th>学校</th>
        <th>QQ</th>
        <th>引荐师兄</th>
        <th>审核师兄</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>电话</th>
        <th>公司</th>


    </tr>
    <c:forEach items= "${task10}" var="task10">
        <tr align="center" >
            <td>${task10.id}</td>
            <td>${task10.name}</td>
            <td>${task10.password}</td>
            <td>${task10.hope}</td>
            <td>${task10.course}</td>
            <td>${task10.date}</td>
            <td>${task10.school}</td>
            <td>${task10.qq}</td>
            <td>${task10.yinjian}</td>
            <td>${task10.shenhe}</td>
            <td>${task10.create}</td>
            <td>${task10.update}</td>
            <td>${task10.phone}</td>
            <td>${task10}.company}</td>
            <%--<td>${List.company}</td>--%>


                <%--<a href="/Task4/student/delete/${task10.id}">删除</a>--%>
                <%--<a href="/Task4/student/update/${task10.id}">修改</a>--%>

        </tr>
    </c:forEach>

</table>
</body>
</html>