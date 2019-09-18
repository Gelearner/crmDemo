<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/13
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8" />
</head>
<body>
<form action="/login" method="post">
    用户：<input type="text" name="username" value="${cookie.ucookie.value}" onblur="checkname(this.value)"><br>
    密码：<input type="password" name="password" value="${cookie.pcookie.value}"><br>
    记住密码：<br><input type="radio" value="7" name="rem">一周
    <br><input type="radio" value="30" name="rem">一月<br>
    <input type="submit" value="登陆">&nbsp;&nbsp;<a href="register.jsp">还没账号，点击注册！</a>
    ${msg}
</form>
</body>
</html>