<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>编辑个人信息</title>
</head>
<body>
<h3>编辑个人信息：</h3>
<s:form action="editStaff" namespace="/" theme="simple">
    <s:hidden name="staff_info.id" value="%{#parameters.id}"/>
    员工编号：<s:textfield name="staff_info.staff_id" value="%{#parameters.staff_id}"/><br>
    &nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;：<s:textfield name="staff_info.staff_name" value="%{#parameters.staff_name}"/><br>
    身份证号：<s:textfield name="staff_info.identity_card" value="%{#parameters.identity_card}"/><br>
    &nbsp;&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;：<s:select list="{'男','女'}" name="staff_info.gender" value="%{#parameters.gender}"/><br>
    <script type="text/javascript" src="HelloWorld/calendar_jh.js"></script>
    入职时间：<s:textfield name="staff_info.entry_date" onclick="popCalendar(this)" value="%{getText('global.date',#parameters.gender ) }">

    </s:textfield><br>

    最终学历：<s:select list="{'专科','本科','研究生','博士','其他'}" name="staff_info.education" value="%{#parameters.education}"/><br>
    家庭住址：<s:textfield name="staff_info.address" value="%{#parameters.address}"/><br>
    联系方式：<s:textfield name="staff_info.tel" value="%{#parameters.tel}"/><br>
    &nbsp;&nbsp;&nbsp;Email&nbsp;&nbsp;&nbsp;：<s:textfield name="staff_info.email" value="%{#parameters.email}"/><br>
    <br>
    <br>

    <span style="margin-left: 300px;">
        <s:submit value="确定"/> <s:reset value="重置"/> <input type="button" onclick="window.location.href='showStaff'" value="取消">
    </span>
</s:form>

</body>
</html>
