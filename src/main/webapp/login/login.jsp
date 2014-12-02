<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>
</head>
<body>
<s:form action="login" namespace="/login">
    <s:textfield name="staff_id" label="员工编号"/>
    <s:password name="password" label="密码"/>
    <s:submit/>
</s:form>


</body>
</html>
