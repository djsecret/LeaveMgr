<%--  
  User: ubuntu
  Date: 14-10-4
  Time: 下午5:29  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Result</title>
</head>
<body>
    <%=request.getParameter("username")%><br>
    <%=request.getParameter("password")%><br>
    <%=request.getParameter("age")%><br>
    <%=request.getParameter("date")%><br>

    username: ${ requestScope.username }<br>
    password: ${ requestScope.password }<br>
    username: ${ requestScope.age }<br>
    username: ${ requestScope.date }<br>
</body>
</html>
