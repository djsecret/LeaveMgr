<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title><s:property value="message.message_name"/></title>
</head>
<body>
    <s:property value="message.id"/><br>
    <s:property value="message.sender_name"/><br>
    <s:property value="message.generate_time"/><br>
    <s:property value="message.message_name"/><br>
    <s:property value="message.type"/><br>
    <s:property value="message.content"/><br>
    <s:property value="message.flag"/><br>

</body>
</html>
