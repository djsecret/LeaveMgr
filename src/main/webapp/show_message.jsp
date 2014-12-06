<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>消息列表</title>

</head>
<body>
<div class="topline"></div>

    <table style=" margin:0 auto; border-collapse: collapse; border: none;" width="100%" align="center">
        <tr style="height: 30px; border-bottom: solid #b2aeba 1px;background-image: url(images/tool_bg104473.gif)">
            <td>消息编号</td>
            <td>发信人</td>
            <td>消息名称</td>
            <td>发送时间</td>
            <td> </td>
        </tr>
        <s:iterator value="messages" id="message">
            <s:if test="flag == @com.neu.common.Constant@MESSAGE_UNREAD_FLAG">
                <tr style="color:#040205; border-bottom: solid rgba(178, 174, 186, 0.97) 1px" >
                    <td>
                        <s:property value="id"/>
                    </td>
                    <td>
                        <s:property value="sender_name"/>
                    </td>
                    <td>
                        <a style="color:#040205;" href="
                        <s:url action="getSingleMessage">
                            <s:param name="message.id" value="#message.id"/>
                        </s:url>"
                                ><s:property value="message_name"/></a>
                    </td>
                    <td>
                        <a style="color:#040205;" href="
                        <s:url action="getSingleMessage">
                            <s:param name="message.id" value="#message.id"/>
                        </s:url>"
                                ><s:date name="generate_time" format="yyyy-MM-dd HH:mm:ss"/></a>

                    </td>

                    <td>
                        <a href="
                        <s:url action="deleteMessage">
                            <s:param name="id" value="#message.id"/>
                        </s:url>"
                                ><img src="images/del1.png" title="删除消息" width="20px" height="20px"></a>
                    </td>
                </tr>
            </s:if>
            <s:else>

                <tr style="color:#85828b; border-bottom: solid rgba(178, 174, 186, 0.97) 1px;">
                    <td>
                        <s:property value="id"/>
                    </td>
                    <td>
                        <s:property value="sender_name"/>
                    </td>
                    <td>
                        <a style="color:#85828b;" href="
                        <s:url action="getSingleMessage">
                            <s:param name="message.id" value="#message.id"/>
                        </s:url>"
                                ><s:property value="message_name"/></a>
                    </td>
                    <td>
                        <a style="color:#85828b;" href="
                        <s:url action="getSingleMessage">
                            <s:param name="message.id" value="#message.id"/>
                        </s:url>"
                                ><s:date name="generate_time" format="yyyy-MM-dd HH:mm:ss"/></a>

                    </td>

                    <td>
                        <a href="
                        <s:url action="deleteMessage">
                            <s:param name="id" value="#message.id"/>
                        </s:url>"
                                ><img title="删除消息" src="images/del1.png" width="20px" height="20px"></a>
                    </td>
                </tr>

            </s:else>

        </s:iterator>
    </table>

</body>
</html>
