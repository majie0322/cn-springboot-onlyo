<%--
  Created by IntelliJ IDEA.
  User: majie
  Date: 2018/2/3
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>login Page</h4>

<form action="/shiro/login" method="post">
    username:<input type="text" name="username"><br/>
    password:<input type="password" name="password"><br/>
    <input type="submit" value="submit">
</form>
</body>
</html>
