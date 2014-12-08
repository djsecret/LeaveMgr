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
    <script type="application/javascript">
        function doDeleteAll()
        {
            var chks = document.getElementsByName("checkbox2");
            var ids = [];
            var count = 0;
            for (var i = 0; i < chks.length; i++)
            {
                if (chks[i].checked)
                {
                    ids.push(chks[i].value);
                    count += 1;
                }
            }
            if (count == 0)
            {
                alert("请选择记录");
            }
            else if (confirm("您选中了【" + count + "】记录，确定删除？"))
            {
                var url = "deleteAllMessage.action?ids=" + ids;
                window.location = url;
            }
        }

    </script>
</head>
<body>
<div class="topline"></div>

    <table style=" margin:0 auto; border-collapse: collapse; border: none;" width="100%" align="center">
        <tr style="height: 30px; border-bottom: solid #b2aeba 1px;background-image: url(images/tool_bg104473.gif)">
            <td width="8%" align="center"><a onclick="doDeleteAll();">删除</a></td>
            <td width="10%">发信人</td>
            <td width="35%">消息名称</td>
            <td width="25%">发送时间</td>
            <td width="5%"> </td>
        </tr>

        <s:iterator value="messages" id="message">
            <s:if test="flag == @com.neu.common.Constant@MESSAGE_UNREAD_FLAG">
                <tr style="color:#040205; border-bottom: solid rgba(178, 174, 186, 0.97) 1px" >
                    <td>
                        <div align="center">
                            <input type="checkbox" name="checkbox2" value="<s:property value="id"/>" />
                        </div>
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
                                ><img src="images/3286.png" title="删除消息" width="18px" height="20px"></a>
                    </td>
                </tr>
            </s:if>
            <s:else>

                <tr style="color:#85828b; border-bottom: solid rgba(178, 174, 186, 0.97) 1px;">
                    <td>
                        <div align="center">
                            <input type="checkbox" name="checkbox2" value="<s:property value="id"/> " />
                        </div>
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
                                ><img title="删除消息" src="images/3286.png" width="18px" height="20px"></a>
                    </td>
                </tr>

            </s:else>

        </s:iterator>
    </table>

</body>
</html>
