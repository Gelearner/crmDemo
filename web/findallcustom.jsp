<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2019/9/15
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty bean.pageData}">
    无用户信息
</c:if>
<c:if test="${not empty bean.pageData}">
    <form action="/delcheck" method="post" onsubmit="tijiao()">
        <table width="80%" height="60%" border="1" cellspacing="0" align="center">
            <caption style="font-size: 25px;color:blue">客户信息</caption>
            <tr>
                <th><input type="checkbox" id="header" onclick="tongbu()"/></th>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>邮箱</th>
                <th>电话</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${bean.pageData}" var="ele" varStatus="v">
                <tr>
                    <td><input type="checkbox" id="content" name="item_cb" class="item_cb" value="${ele.cid}"/></td>
                    <td>${v.count}</td>
                    <td>${ele.cname}</td>
                    <td>${ele.age}</td>
                    <td>${ele.gender}</td>
                    <td>${ele.email}</td>
                    <td>${ele.telephone}</td>
                    <td>${ele.description}</td>
                    <td>&nbsp;&nbsp;&nbsp;<a href="/delcustomer?cid=${ele.cid}" )>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
                            href="/findupdata?cid=${ele.cid}">修改</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="9">
                        ${bean.currentPage}/${bean.totalPage}页
                    <a href="/findall?currentpage=${bean.currentPage-1>1?bean.currentPage-1:1}">上一页</a>
                    <a href="/findall?currentpage=${bean.currentPage+1<bean.totalPage?bean.current+1:bean.totalPage}">下一页</a>
                    <a href="/findall?currentpage=${bean.totalPage}">末页</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="#" onclick="checkall()">全选</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="#" onclick="reversec()">反选</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" value="删除选中">
                </td>
            </tr>
        </table>
    </form>
</c:if>


</body>
<script>
    function tongbu() {
        var headerobj=document.getElementById("header");
        var contextobj=document.getElementsByClassName("item_cb");
        for (var i = 0; i < contextobj.length; i++) {
            contextobj[i].checked=headerobj.checked;
        }
    }

    function checkall() {
        var contextobj=document.getElementsByClassName("item_cb");
        for (var i = 0; i < contextobj.length; i++) {
            contextobj[i].checked=true;
        }
    }

    function reversec() {
        var contextobj=document.getElementsByClassName("item_cb");
        for (var i = 0; i < contextobj.length; i++) {
            contextobj[i].checked=!contextobj[i].checked;
        }
    }

    function tijiao() {
        return window.confirm("你确定删除吗？");
    }
</script>
</html>
