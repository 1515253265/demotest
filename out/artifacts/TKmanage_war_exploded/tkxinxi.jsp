<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/5/26
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>逃课信息</title>
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
<%@include file="top.jsp"%>
<a href="/login?type=student&username=${student.username}&password=${student.password}">首页</a><br>
<h3>欢迎：${student.name}</h3>
<div id="main" align="center">
<table cellpadding="0" class="table">
 <tr>
     <td>编号</td>
     <td>课程名</td>
     <td>任课教师</td>
     <td>日期</td>
     <td>状态</td>
     <td>操作</td>
 </tr>
    <c:forEach items="${list}" var="tkmetrics">
        <tr>
        <td>${tkmetrics.tno}</td>
        <td>${tkmetrics.course.cname}</td>
        <td>${tkmetrics.teacher.lname}</td>
        <td>${tkmetrics.date}</td>
        <td>
            <c:if test="${tkmetrics.state == 4}">
                <font color="red">旷课</font>
            </c:if>
            <c:if test="${tkmetrics.state == 0}">
                <font color="blue">旷课</font>
            </c:if>
            <c:if test="${tkmetrics.state == 1}">
                <font color="yellow">审核中</font>
            </c:if>
            <c:if test="${tkmetrics.state == 2}">
                <font color="green">正常</font>
            </c:if>
        </td>
        <td>
            <c:if test="${tkmetrics.state == 0}">
            <a href="/TK?method=handle&tno=${tkmetrics.tno}&state=1&sno=${tkmetrics.student.sno}&cno=${tkmetrics.course.cno}&page=1">申请</a>
            </c:if>
    </c:forEach>
    <br>

</body>
</html>
