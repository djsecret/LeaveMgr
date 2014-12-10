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
    <link rel="stylesheet" href="../css/styles.css" type="text/css"/>
</head>
<body>
    发送人：<s:property value="message.sender_name"/>&nbsp;&nbsp;&nbsp;&nbsp;发送时间：<s:date name="message.generate_time" format="yyyy年MM月dd日 HH:mm:ss"/><br>
    标题：<s:property value="message.message_name"/><br>
    <br>
    <br>
    <div class="event">
        <s:if test="message.type == @com.neu.common.Constant@MESSAGE_LEAVE_APPLY_TYPE || message.type == @com.neu.common.Constant@MESSAGE_LEAVE_RESUMPTION_TYPE || message.type == @com.neu.common.Constant@MESSAGE_LEAVE_DELIVER_TYPE">

        <span>请假单</span>

        <div class="info">
            <div style="float:right; font-size: 14px; color: #f44f55; ">
                请假事务编号：<s:property value="leave_info.id"/><br>
            </div><br>

            <br>

            请假人：<s:property value="leave_info.proposer_name"/><br>
            起始时间：<s:date name="leave_info.begin_time" format="yyyy年MM月dd日"/><br>
            请假天数：<s:property value="leave_info.days"/>天<br>
            <div style="width: 450px">
                事由：<s:property  value="leave_info.reason"/>
            </div><br>

            <div style="float:right;">
                申请时间：<s:date name="leave_info.apply_time" format="yyyy年MM月dd日 HH:mm:ss"/>
            </div><br>

            <div style="float:right;">
                状态：
                <s:if test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_ALLPY_RESULT">
                    待审核<br>
                    <br>
                    <a href="
                    <s:url action="allowLeave" namespace="/leave">
                        <s:param name="leave_info.id" value="leave_info.id"/>
                        <s:param name="token" value="#session.allow_session_token"/>
                    </s:url>"
                            >审核通过</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="
                    <s:url action="rejectLeave" namespace="/leave">
                        <s:param name="leave_info.id" value="leave_info.id"/>
                        <s:param name="token" value="#session.reject_session_token"/>
                    </s:url>"
                            >否决</a>
                </s:if>

                <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_REJECT_RESULT">
                    请假被否决<br>
                </s:elseif>

                <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_ALLOW_RESULT">
                    请假通过<br>
                </s:elseif>

                <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_CANCEL_RESULT">
                    申请取消<br>
                </s:elseif>

                <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_RESUMPTION_RESULT">
                    销假待审核<br>
                    <br>
                    <a href="
                    <s:url action="archiveLeave" namespace="/leave">
                        <s:param name="leave_info.id" value="leave_info.id"/>
                        <s:param name="token" value="#session.archive_session_token"/>
                    </s:url>"
                            >销假归档</a>
                </s:elseif>

                <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_ARCHIVE_RESULT">
                    销假归档<br>
                </s:elseif>
                <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_DELIVER_RESULT">
                    天数超过<s:property value="@com.neu.common.Constant@DAYS_THRESHOLD"/>，待总经理审核 <br>
                    <br>
                    <s:if test="%{#session.staff_login.rank == 1}">
                        <a href="
                            <s:url action="allowLeave" namespace="/leave">
                                <s:param name="leave_info.id" value="leave_info.id"/>
                                <s:param name="token" value="#session.allow_session_token"/>
                            </s:url>"
                                >审核通过</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="
                            <s:url action="rejectLeave" namespace="/leave">
                                <s:param name="leave_info.id" value="leave_info.id"/>
                                <s:param name="token" value="#session.reject_session_token"/>
                            </s:url>"
                                >否决</a>
                    </s:if>
                </s:elseif>
            </div>
        </s:if>
        <s:else>
            <br>
            <br>
            <div class="info">
                <s:property value="message.content"/><br>
            </div>
        </s:else>
        <br>
        </div>

    </div>
    <br>
    <a href="/message/showMessage" title="返回"><img src="../images/back.png" width="60px;" height="60px;"></a>
    <br>

</body>
</html>
