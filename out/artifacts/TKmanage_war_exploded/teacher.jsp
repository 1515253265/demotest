<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/5/31
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

欢迎：${teacher.lname}

<br>
<table cellpadding="0" class="table">
    <tr>
        <td>编号</td>
        <td>课程名</td>
        <td>学号</td>
        <td>学生姓名</td>
        <td>日期</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="tkmetrics">
        <tr>
            <td>${tkmetrics.tno}</td>
            <td>${tkmetrics.course.cname}</td>
            <td>${tkmetrics.student.sno}</td>
            <td>${tkmetrics.student.name}</td>
            <td>${tkmetrics.date}</td>
            <td>
                <c:if test="${tkmetrics.state == 0}">
                    <font color="red">旷课</font>
                </c:if>
                <c:if test="${tkmetrics.state == 1}">
                    <font color="yellow">待审核</font>

                </c:if>
                <c:if test="${tkmetrics.state == 2}">
                    <font color="green">正常</font>
                </c:if>
            </td>
            <td>
                <c:if test="${tkmetrics.state == 1}">
                    <a href="">同意</a>
                    <a href="">拒绝</a>
                </c:if>
            </td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
