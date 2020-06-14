<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/6/7
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <title>添加逃课学生</title>
    <style>
        body{
            background: azure;
        }
        table,td,th{
            border: 0px solid black;
        }
        table{
            width: 70%;
        }
        th{
            height: 50px;
        }
    </style>
</head>
<body>
<%@include file="top.jsp"%><br>
<a href="/teacher?method=findAll&username=${teacher.username}&page=1">返回</a>
<br>
欢迎:   ${teacher.lname}
<a href="/logout">注销</a>
<br>
<div align="center">
<table cellpadding="0" class="table">
    <tr>
        <td>课程号</td>
        <td>课程名</td>
        <td>学号</td>
        <td>学生姓名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="course">
        <tr>
            <td>${course.cno}</td>
            <td>${course.cname}</td>
            <td>${course.student.sno}</td>
            <td>${course.student.name}</td>
            <td>
                <a href="/teacher?method=insert&cno=${course.cno}&sno=${course.student.sno}&lno=${course.teacher.lno}">添加</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
