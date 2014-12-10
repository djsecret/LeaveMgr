<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>请假</title>
    <link rel="stylesheet" href="../css/styles.css" type="text/css"/>
    <script type="text/javascript" src="../HelloWorld/calendar_jh.js"></script>

</head>
<body>

    <div class="event" style="margin-top: 20px;">
        <span>请假单</span>

        <div class="info">
            <s:form action="addLeave" namespace="/leave" theme="simple">

                起始日期: <s:textfield name="leave_info.begin_time" onclick="popCalendar(this)"/><br>
                <br>
                请假天数: <s:textfield name="leave_info.days" size="6"/><br>
                <br>
                <label style="vertical-align:top">请假事由:</label>
                <s:textarea name="leave_info.reason" cols="25" rows="5"/> <br>

                <span style="float:right;margin-top: 10px;">
                    <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重填">
                </span>
            </s:form>
        </div>

    </div>

</body>
</html>
