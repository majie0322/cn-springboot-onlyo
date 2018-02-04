<%--
  Created by IntelliJ IDEA.
  User: majie
  Date: 2018/2/3
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>User Page</h4>
welcome :<shiro:principal></shiro:principal>
<shiro:hasRole name="admin">
    <a href="admin.jsp">admin</a><br/>
</shiro:hasRole>

<shiro:hasRole name="user">
    <a href="user.jsp">user</a><br/>
</shiro:hasRole>
<a href="shiro/logout">Logout</a>
</body>
</html>
