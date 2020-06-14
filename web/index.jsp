<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/5/25
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title>课程信息</title>
  </head>
  <%@ include file="top.jsp"%>
  <br>

  欢迎:   ${student.name}
  <a href="/logout">注销</a>
  <div align="center"> <br>
<table  cellpadding="0" class="table">
  <tr>
      <td>课程名  &nbsp; </td>
      <td>任课老师  &nbsp; </td>
      <td>查看记录  &nbsp; </td>
  </tr>
  <c:forEach items="${list}" var="course">
    <tr>
      <td>${course.cname}</td>
        <td>${course.teacher.lname}</td>
        <td>
          <a href="/TK?method=findAllTk&cno=${course.cno}&sno=${course.student.sno}&page=1">进入</a>
        </td>
    </tr>
  </c:forEach>
</table>
  </div>
  <%@include file="footer.jsp"%>
  </body>
</html>
