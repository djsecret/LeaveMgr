<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<!--
    <%=request.getParameter("staff_id")%><br>
    <%=request.getParameter("password")%><br>

    username: ${ requestScope.staff_id }<br>
    password: ${ requestScope.password }<br>
-->
    <table width="80%" align="center" border="1">
        <tr>
            <th>消息编号</th>
            <th>发信人</th>
            <th>消息名称</th>
            <th>发送时间</th>
            <th>查看</th>
            <th>删除</th>
        </tr>
        <s:iterator value="messages" id="message">
            <tr>
                <td>
                    <s:property value="id"/>
                </td>
                <td>
                    <s:property value="sender_name"/>
                </td>
                <td>
                    <s:property value="message_name"/>
                </td>
                <td>
                    <s:property value="generate_time"/>
                </td>
                <td>
                    <a href="
                        <s:url action="getSingleMessage">
                            <s:param name="message.id" value="#message.id"/>
                        </s:url>"
                            >查看</a>

                </td>
                <td>
                    <a href="
                        <s:url action="deleteMessage">
                            <s:param name="id" value="#message.id"/>
                        </s:url>"
                            >删除</a>
                </td>
            </tr>
        </s:iterator>
    </table>

</body>
</html>
