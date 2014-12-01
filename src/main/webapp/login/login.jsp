<%--  
  User: ubuntu
  Date: 14-10-4
  Time: 下午4:43  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Login</title>
</head>
<body>
    <form action="login.action">
        username:<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        age:<input type="text" name="age"><br>
        date:<input type="text" name="date"><br>
        <input type="submit">
    </form>

</body>
</html>
