<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2019/9/15
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<head>
    <title>Title</title>
</head>
<center>
    <h1>客户信息管理系统</h1>
</center>
<br>
<div id="welcomeuser" style="float: left;">
    ${user.username}你好呀！
</div>
<center>
    <div id="time" align="right">
        时间
    </div>
</center>
<div id="saftexit" style="float:right;">
    <a href="javascript void(0)" onclick="thinkexit()">安全退出</a>
</div>
</body>
<script type="text/javascript">
    function flushtime(){
        var date=new Date();
        var time=date.toLocaleString();
        document.getElementById("time").innerText=time;
    }
    flushtime();
    setInterval(flushtime,500);

    function thinkexit() {
        if (confirm("你确定要退出吗？退出会删除所用的记录！")) {
            window.parent.location.href="${pageContext.request.contextPath}/exit";
        }else {
            window.parent.location.href="${pageContext.request.contextPath}/home.jsp";
        }
    }
</script>
</html>
