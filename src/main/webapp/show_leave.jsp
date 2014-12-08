<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>请假申请记录</title>
</head>
<body>
<div class="topline"></div>
<table style=" margin:0 auto; border-collapse: collapse; border: none;" width="100%" align="center">
    <tr style="height: 30px; border-bottom: solid #b2aeba 1px;background-image: url(images/navbar.gif); color: rgba(14, 14, 19, 0.61);">
        <td width="20%" align="center">起始时间</td>
        <td width="10%">请假天数</td>
        <td width="30%">申请时间</td>
        <td width="10%">审核者</td>
        <td width="25%">状态</td>
        <td></td>
    </tr>
    <s:iterator value="leave_infos" id="leave">
        <tr style="border-bottom: solid rgba(178, 174, 186, 0.97) 1px;">

            <td align="center">
                <s:date name="begin_time" format="yyyy年MM月dd日"/>
            </td>
            <td align="center">
                <s:property value="days"/>
            </td>
            <td>
                <s:date name="apply_time" format="yyyy年MM月dd日 HH:MM:ss"/>
            </td>
            <td>
                <s:property value="auditor_name"/>
            </td>
            <td>
                <s:if test="result == @com.neu.common.Constant@LEAVE_INFO_ALLPY_RESULT">
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
                <s:elseif test="result == @com.neu.common.Constant@LEAVE_INFO_DELIVER_RESULT">
                    天数超过<s:property value="@com.neu.common.Constant@DAYS_THRESHOLD"/>，待总经理审核 <br>
                </s:elseif>
                <s:elseif test="result == @com.neu.common.Constant@LEAVE_INFO_CANCEL_RESULT">
                    申请取消<br>
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
                <s:elseif test="valid == @com.neu.common.Constant@LEAVE_INFO_INVALID && result == @com.neu.common.Constant@LEAVE_INFO_ALLPY_RESULT">
                    <a href="
                        <s:url action="cancelLeave">
                            <s:param name="id" value="#leave.id"/>
                        </s:url>" >取消
                    </a>
                </s:elseif>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
