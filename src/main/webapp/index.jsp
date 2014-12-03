<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
</head>
<body>
    <s:a href="login.jsp">登录</s:a>
    <s:if test="%{#session.staff_login != null}">
        <s:a action="logout">注销</s:a>
        <s:a href="show_message.jsp">消息</s:a>
        <s:a href="addLeave.jsp">请假</s:a>

    </s:if>


</body>
</html>
