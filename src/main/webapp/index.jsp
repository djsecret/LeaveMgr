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
        <s:a action="showMessage">消息</s:a>
        <s:a href="addLeave.jsp">请假</s:a>
        <s:a action="showStaff">个人信息</s:a>
        <!--
        <a href="
            <s:url action="showStaff"/>
            " target="_blank"
                >个人信息</a>
                -->
    </s:if>


</body>
</html>
