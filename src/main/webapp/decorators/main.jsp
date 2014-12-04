<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="decorator"
          uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="../css/menu.css" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/menu.js"></script>
    <decorator:head />
</head>
<body>
<s:if test="%{#session.staff_login == null}">
    <s:a href="login.jsp" cssStyle="float: right">登录</s:a>
</s:if>

<s:if test="%{#session.staff_login != null}">
    <span style="float: right">
        您好！<s:property value="#session.staff_login.staff_name"/>
    <s:a action="logout">注销</s:a>
    <s:a action="showMessage">消息</s:a>
    </span>

</s:if>
    <ul>
        <li class="main">
            <a href="#" onclick="return false">请销假</a>
            <ul>
                <li>
                    <a href="../addLeave.jsp">新建请假申请</a>
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
    <decorator:body />
</body>
</html>
