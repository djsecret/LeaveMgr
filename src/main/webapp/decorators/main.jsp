<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="decorator"
          uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>

    <link rel="stylesheet" href="css/styles.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery-tool.css" type="text/css" />

    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.tools.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
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
<table>
    <tr>
        <td width="200px"></td>
        <td valign="top">
            <div id="content">
                <ul id="expmenu-freebie">
                    <li>
                        <!-- Start Freebie -->
                        <ul class="expmenu">
                            <li>
                                <div class="header">
                                    <span class="label" style="background-image: url(images/messages.png);">请销假</span>
                                    <span class="arrow up"></span>
                                </div>
                                <ul class="menu">
                                    <li class="selected"><a href="addLeave.jsp">新建请假申请</a></li>
                                    <li><a href="showLeave" >请假申请记录</a></li>
                                </ul>
                            </li>
                            <li>
                                <div class="header">
                                    <span class="label" style="background-image: url(images/user.png);">个人信息维护</span>
                                    <span class="arrow up"></span>
                                </div>
                                <ul class="menu">
                                    <li><a href="showStaff" >个人信息</a></li>
                                    <li><a href="#" onclick="return false">修改密码</a></li>
                                </ul>
                            </li>
                            <!--
                            <li>
                                <div class="header">
                                    <span class="label" style="background-image: url(images/pc.png);">Screen Settings</span>
                                    <span class="arrow down"></span>
                                </div>
                                <ul class="menu" style="display:none">
                                    <li>Your settings</li>
                                </ul>
                            </li>
                            <li>
                                <div class="header">
                                    <span class="label" style="background-image: url(images/search.png);">Search</span>
                                </div>
                            </li>
                            -->
                        </ul>
                        <!-- End Freebie -->
                    </li>
                </ul>
            </div>
        </td>

        <td width="1200" valign="top" style="padding: 40px;">
            <decorator:body />
        </td>
    </tr>
</table>
</body>
</html>