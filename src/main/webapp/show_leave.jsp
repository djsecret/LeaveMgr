<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>请假申请记录</title>
</head>
<body>
<table width="80%" align="center" border="1">
    <tr>
        <th>请假编号</th>
        <th>起始时间</th>
        <th>请假天数</th>
        <th>申请时间</th>
        <th>审核者</th>
        <th>状态</th>
        <th>销假</th>
    </tr>
    <s:iterator value="leave_infos" id="leave">
        <tr>
            <td>
                <s:property value="id"/>
            </td>
            <td>
                <s:date name="begin_time" format="yyyy年MM月dd日"/>
            </td>
            <td>
                <s:property value="days"/>
            </td>
            <td>
                <s:date name="apply_time" format="yyyy年MM月dd日 HH:mm:ss"/>
            </td>
            <td>
                <s:property value="auditor_name"/>
            </td>
            <td>
                <s:if test="valid == @com.neu.common.Constant@LEAVE_INFO_INVALID">
                    请假待审核<br>
                </s:if>
                <s:elseif test="result == @com.neu.common.Constant@LEAVE_INFO_REJECT_RESULT">
                    请假被否决<br>
                </s:elseif>
                <s:elseif test="result == @com.neu.common.Constant@LEAVE_INFO_ALLOW_RESULT">
                    请假通过<br>
                </s:elseif>
                <s:elseif test="result == @com.neu.common.Constant@LEAVE_INFO_RESUMPTION_RESULT">
                    销假待审核<br>
                </s:elseif>
                <s:elseif test="result == @com.neu.common.Constant@LEAVE_INFO_ARCHIVE_RESULT">
                    销假归档<br>
                </s:elseif>
            </td>
            <td>
                <s:if test="valid == @com.neu.common.Constant@LEAVE_INFO_VALID && result == @com.neu.common.Constant@LEAVE_INFO_ALLOW_RESULT">
                    <a href="
                        <s:url action="resumptionfromleave">
                            <s:param name="id" value="#leave.id"/>
                        </s:url>" >销假
                    </a>
                </s:if>
                <s:else>-</s:else>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
