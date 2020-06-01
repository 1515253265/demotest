<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/5/25
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <table border="0">
        <tr>
            <td class="title">用户名:</td>
            <td class="input">
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td class="title">密码:</td>
            <td class="input">
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td class="title">用户类型:</td>
            <td class="input">
                <input type="radio" name="type" value="student" checked="checked"/>学生
                <input type="radio" name="type" value="teacher"/>老师
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
