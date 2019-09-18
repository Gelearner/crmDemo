<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2019/9/16
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/updatacustomer" method="post">
    <table align="center" width="65%" height="55%" border="1" cellspacing="0">
        <caption style="color: blue;font-size: 25px">修改客户</caption>
        <input type="hidden" name="cid" value="${customer.cid}"/>
        <tr>
            <td>客户姓名:</td>
            <td><input type="text" name="cname" value="${customer.cname}"/></td>
        </tr>
        <tr>
            <td>客户年龄:</td>
            <td><input type="text" name="age" value="${customer.age}"/></td>
        </tr>
        <tr>
            <td>客户性别:</td>
            <td>
                <c:if test="${customer.gender.equals('男')}">
                    <input type="radio" name="gender" value="男" checked="checked" />男
                    <input type="radio" name="gender" value="女" />女
                </c:if>
                <c:if test="${customer.gender.equals('女')}">
                <input type="radio" name="gender" value="男"  />男
                <input type="radio" name="gender" value="女" checked="checked"/>女
                </c:if>
            </td>
        </tr>
        <tr>
            <td>客户邮箱:</td>
            <td><input type="text" name="email" value="${customer.email}"/></td>
        </tr>
        <tr>
            <td>客户电话:</td>
            <td><input type="text" name="telephone" value="${customer.telephone}"/></td>
        </tr>
        <tr>
            <td>客户备注:</td>
            <td><textarea name="description" rows="8" cols="25">
                ${customer.description}
            </textarea></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改" class="btn" />&nbsp;&nbsp;<input type="reset" value="重置" class="btn" /></td>
        </tr>
    </table>
</form>
</body>
</html>
