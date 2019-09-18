<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2019/9/15
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${user.username}</title>
</head>
<c:if test="${empty user}">
    <frameset>
        <frame src="404.jsp">
    </frameset>
</c:if>
<c:if test="${not empty user}">
    <frameset rows="20%,*">
        <frame src="top.jsp" noresize="noresize" />
        <frameset cols="30%,*">
            <frame src="left.jsp" noresize="noresize">
            <frame src="right.jsp" noresize="noresize" name="mycontent"/>
        </frameset>
    </frameset>
</c:if>
</html>
