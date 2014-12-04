<%@ page import="com.neu.common.Constant" %>
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
    消息编号：<s:property value="message.id"/>&nbsp;&nbsp;&nbsp;&nbsp;发送人：<s:property value="message.sender_name"/><br>
    标题：<s:property value="message.message_name"/>&nbsp;&nbsp;&nbsp;&nbsp;发送时间：<s:property value="message.generate_time"/><br>
    <br>
    <br>
    <s:if test="message.type == 0">
        请假事务编号：<s:property value="leave_info.id"/><br>
        请假人：<s:property value="leave_info.proposer_name"/><br>
        起始时间：<s:property value="leave_info.begin_time"/>&nbsp;&nbsp;&nbsp;&nbsp;请假天数：<s:property value="leave_info.days"/><br>
        事由：<s:property value="leave_info.reason"/><br>
        申请时间：<s:property value="leave_info.apply_time"/><br>
        状态：
        <s:if test="leave_info.valid == @com.neu.common.Constant@LEAVE_INFO_INVALID">
            待审核<br>
            <a href="
            <s:url action="allowLeave">
                <s:param name="leave_info.id" value="leave_info.id"/>
                <s:param name="leave_info.result" value="@com.neu.common.Constant@LEAVE_INFO_ALLOW_RESULT"/>
            </s:url>"
                    >审核通过</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="
            <s:url action="rejectLeave">
                <s:param name="leave_info.id" value="leave_info.id"/>
                <s:param name="leave_info.result" value="@com.neu.common.Constant@LEAVE_INFO_REJECT_RESULT"/>
            </s:url>"
                    >否决</a>
        </s:if>
        <s:if test="leave_info.valid == @com.neu.common.Constant@LEAVE_INFO_VALID && leave_info.result == @com.neu.common.Constant@LEAVE_INFO_REJECT_RESULT">
            否决<br>
        </s:if>
        <s:if test="leave_info.valid == @com.neu.common.Constant@LEAVE_INFO_VALID && leave_info.result == @com.neu.common.Constant@LEAVE_INFO_ALLOW_RESULT">
            通过<br>
        </s:if>

    </s:if>
    <br>

</body>
</html>
