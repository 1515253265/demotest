<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/5/31
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>查看所有学生记录</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#next").click(function(){
                var pages = parseInt($("#pages").html());
                var page = parseInt($("#currentPage").html());
                var name = "${teacher.username}";
                if(page == pages){
                    return;
                }
                page++;
                window.location.href = "/teacher?username="+name+"&page="+page;
            })

            $("#previous").click(function () {
                var page = parseInt($("#currentPage").html());
                var name = "${teacher.username}";
                if(page == 1){
                    return;
                }
                page--;
                window.location.href ="/teacher?username="+name+"&page="+page;
            })

            $("#first").click(function () {
                var name = "${teacher.username}";
                window.location.href ="/teacher?username="+name+"&page=1";
            })

            $("#last").click(function(){
                var pages = parseInt($("#pages").html());
                var name = "${teacher.username}";
               window.location.href ="/teacher?username="+name+"&page="+pages;
            })
        })
    </script>
<style>
    #main{
        width: 1080px;
        height: 650px;
        border: 1px solid #EDC56F;
        position: relative;
    }
    #pageControl{
        width: 100%;
        height: auto;
        position: relative;
        position: absolute;
        bottom:10px;
        font-size: 13px;
    }
    .pageControl_item{
        width:120px;
        height: 30px;
        line-height: 30px;
        float: right;
        margin-right: 30px;
        cursor: pointer;
    }

    .pageControl_item_disabled{
        color:gray;
    }

    .hr{
        border:none;
        border-top:1px solid #DFA40C;
        height: 1px;
        margin-top: 40px;
        width: 96%;
    }
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
欢迎：${teacher.lname}
<a href="/logout">注销</a>
<br>
<div id="main" align="center">
<table cellpadding="0" class="table">
    <tr>
        <td>编号</td>
        <td>课程名</td>
        <td>学号</td>
        <td>学生姓名</td>
        <td>班级</td>
        <td>年级</td>
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
            <td>${tkmetrics.student.scar}</td>
            <td>${tkmetrics.student.grade}</td>
            <td>${tkmetrics.date}</td>
            <td>
                <c:if test="${tkmetrics.state == 4}">
                    <font color="red">旷课</font>
                </c:if>
                <c:if test="${tkmetrics.state == 0}">
                    <font color="blue">旷课</font>
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
                    <a href="/teacher?method=handle&tno=${tkmetrics.tno}&state=2&username=${tkmetrics.teacher.username}">同意</a>
                    <a href="/teacher?method=handle&tno=${tkmetrics.tno}&state=4&username=${tkmetrics.teacher.username}">拒绝</a>
                </c:if>
                <c:if test="${tkmetrics.state == 2}">
                    <a href="/teacher?method=delete&tno=${tkmetrics.tno}&username=${tkmetrics.teacher.username}">删除</a>
                </c:if>
                <c:if test="${tkmetrics.state == 0}">
                    <a href="/teacher?method=delete&tno=${tkmetrics.tno}&username=${tkmetrics.teacher.username}">删除</a>
                </c:if>
            </td>

        </tr>
    </c:forEach>
    <br>
    <a href="/teacher?method=findAllByLno&lno=${teacher.lno}">添加逃课学生</a>
</table>
    <hr class="hr"/>
    <div id="pageControl">
        <div class="pageControl_item">每页<font id="dataPrePage">${dataPrePage}</font>条数据</div>
        <div class="pageControl_item" id="last">最后一页</div>
        <div class="pageControl_item" id="next">下一页</div>
        <div class="pageControl_item"><font id="currentPage">${currentPage}</font>/<font id="pages">${pages}</font></div>
        <div class="pageControl_item" id="previous">上一页</div>
        <div class="pageControl_item" id="first">首页</div>
    </div>
</div>
</body>
</html>
