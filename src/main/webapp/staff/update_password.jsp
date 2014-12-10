<%--  
  User: ubuntu
  Date: 14-12-5
  Time: 下午4:42  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>修改密码</title>
</head>
<body>
    <s:form action="updatePassword" namespace="/staff" method="POST">
        <s:password name="password" label="原密码"/>
        <s:password name="newPassword" label="新密码"/>
        <s:password name="rePassword" label="确认新密码"/>
        <s:submit value="确定"/>
    </s:form>
</body>
</html>
