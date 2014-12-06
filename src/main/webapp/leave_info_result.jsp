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
    <title>请假审核结果</title>
</head>
<body>

        请假事务编号：<s:property value="leave_info.id"/><br>
        请假人：<s:property value="leave_info.proposer_name"/><br>
        起始时间：<s:property value="leave_info.begin_time"/>&nbsp;&nbsp;&nbsp;&nbsp;请假天数：<s:property value="leave_info.days"/><br>
        事由：<s:property value="leave_info.reason"/><br>
        申请时间：<s:property value="leave_info.apply_time"/><br>
        状态：
        <s:if test="leave_info.valid == @com.neu.common.Constant@LEAVE_INFO_INVALID">
            请假待审核<br>
        </s:if>
        <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_REJECT_RESULT">
            请假被否决<br>
        </s:elseif>
        <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_ALLOW_RESULT">
            请假通过<br>
        </s:elseif>
        <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_RESUMPTION_RESULT">
            销假待审核<br>
        </s:elseif>
        <s:elseif test="leave_info.result == @com.neu.common.Constant@LEAVE_INFO_ARCHIVE_RESULT">
            销假归档<br>
        </s:elseif>
        <br>
        审核者：<s:property value="leave_info.auditor_name"/>&nbsp;&nbsp;&nbsp;&nbsp;处理时间：<s:property value="leave_info.handle_time"/><br>
        <br>
        <a style="margin-left: 300px;" href="showMessage">返回</a>

</body>
</html>
