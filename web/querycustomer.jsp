<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2019/9/16
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/querycustomer" method="post" onsubmit="tijiao()">
        <center>
            姓名：<input type="text" name="cname"/>
            <input type="submit" value="查询"/>
        </center>
    </form>
    <table width="80%" height="60%" border="1" cellspacing="0" align="center">
        <caption style="font-size: 25px;color:blue">客户信息</caption>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>备注</th>
        </tr>
        <c:forEach items="${customerlist}" var="ele" varStatus="v">
        <tr>
            <td>${v.count}</td>
            <td>${ele.cname}</td>
            <td>${ele.age}</td>
            <td>${ele.gender}</td>
            <td>${ele.email}</td>
            <td>${ele.telephone}</td>
            <td>${ele.description}</td>
            </c:forEach>
    </table>
</body>
</html>
