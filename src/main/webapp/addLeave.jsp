<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>请假</title>
</head>
<body>
    新的请假申请单：<br>
    <s:form action="addLeave" namespace="/" theme="simple">
        起始日期: <s:textfield name="leave_info.begin_time"/><br>
        请假天数: <s:textfield name="leave_info.days"/><br>
        请假事由: <s:textarea name="leave_info.reason" cols="15" rows="5"/> <br>
        <input type="submit" value="提交"><input type="reset" value="重填">
    </s:form>
</body>
</html>
