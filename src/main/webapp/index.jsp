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
    <link type="text/css" rel="stylesheet" href="css/menu.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>
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
    <ul>
        <li class="main">
            <a href="#" onclick="return false">请销假</a>
            <ul>
                <li>
                    <a href="addLeave.jsp">新建请假申请</a>
                </li>
                <li>
                    <a href="#">请假申请记录</a>
                </li>
            </ul>
        </li>
        <li class="main">
            <a href="#" onclick="return false">个人信息维护</a>
            <ul>
                <li>
                    <a href="
                        <s:url action="showStaff"/>
                        " >个人信息</a>
                </li>
                <li>
                    <a href="#">修改密码</a>
                </li>
            </ul>
        </li>
    </ul>
    <br />

</body>
</html>
