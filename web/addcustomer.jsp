<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2019/9/16
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addCustomer" method="post">
    <table align="center" width="65%" height="55%" border="1" cellspacing="0">
        <caption style="color: blue;font-size: 25px">添加客户</caption>
        <tr>
            <td>客户姓名:</td>
            <td><input type="text" name="cname" /></td>
        </tr>
        <tr>
            <td>客户年龄:</td>
            <td><input type="text" name="age" /></td>
        </tr>
        <tr>
            <td>客户性别:</td>
            <td>
                <input type="radio" name="gender" value="男" checked="checked" />男
                <input type="radio" name="gender" value="女" />女
            </td>
        </tr>
        <tr>
            <td>客户邮箱:</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>客户电话:</td>
            <td><input type="text" name="telephone" /></td>
        </tr>
        <tr>
            <td>客户备注:</td>
            <td><textarea name="description" rows="8" cols="25"></textarea></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="添加" class="btn" />&nbsp;&nbsp;<input type="reset" value="重置"
                                                                                             class="btn" /></td>
        </tr>
        ${addmsg}
    </table>
</form>
</body>
</html>
