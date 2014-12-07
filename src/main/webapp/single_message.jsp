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
    标题：<s:property value="message.message_name"/>&nbsp;&nbsp;&nbsp;&nbsp;发送时间：<s:date name="message.generate_time" format="yyyy年MM月dd日 HH:mm:ss"/><br>
    <br>
    <br>
    <s:if test="message.type == @com.neu.common.Constant@MESSAGE_LEAVE_APPLY_TYPE || message.type == @com.neu.common.Constant@MESSAGE_LEAVE_RESUMPTION_TYPE || message.type == @com.neu.common.Constant@MESSAGE_LEAVE_DELIVER_TYPE">
        请假事务编号：<s:property value="leave_info.id"/><br>
        请假人：<s:property value="leave_info.proposer_name"/><br>
        起始时间：<s:date name="leave_info.begin_time" format="yyyy年MM月dd日"/>&nbsp;&nbsp;&nbsp;&nbsp;请假天数：<s:property value="leave_info.days"/><br>
        事由：<s:property value="leave_info.reason"/><br>
        申请时间：<s:date name="leave_info.apply_time" format="yyyy年MM月dd日 HH:mm:ss"/><br>
        状态：
        <s:if test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_ALLPY_RESULT">
            待审核<br>
            <a href="
            <s:url action="allowLeave">
                <s:param name="leave_info.id" value="leave_info.id"/>
            </s:url>"
                    >审核通过</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="
            <s:url action="rejectLeave">
                <s:param name="leave_info.id" value="leave_info.id"/>
            </s:url>"
                    >否决</a>
        </s:if>
        
        <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_REJECT_RESULT">
            请假被否决<br>
        </s:elseif>
        
        <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_ALLOW_RESULT">
            请假通过<br>
        </s:elseif>
        
        <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_RESUMPTION_RESULT">
            销假待审核<br>
            <a href="
            <s:url action="archiveLeave">
                <s:param name="leave_info.id" value="leave_info.id"/>
            </s:url>"
                    >销假归档</a>
        </s:elseif>
        
        <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_ARCHIVE_RESULT">
            销假归档<br>
        </s:elseif>
        <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_DELIVER_RESULT">
            天数超过<s:property value="@com.neu.common.Constant@DAYS_THRESHOLD"/>，待总经理审核 <br>
            <s:if test="%{#session.staff_login.rank == 1}">
                <a href="
                    <s:url action="allowLeave">
                        <s:param name="leave_info.id" value="leave_info.id"/>
                    </s:url>"
                        >审核通过</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="
                    <s:url action="rejectLeave">
                        <s:param name="leave_info.id" value="leave_info.id"/>
                    </s:url>"
                        >否决</a>
            </s:if>
        </s:elseif>
    </s:if>
    <br>
    <a style="margin-left: 300px;" href="showMessage">返回</a>
    <br>

</body>
</html>
