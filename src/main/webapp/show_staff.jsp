<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>个人信息</title>
</head>
<body>
<h3>个人信息：</h3>
<br>
员工编号：<s:property value="staff_info.staff_id"/><br>
&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;：<s:property value="staff_info.staff_name"/><br>
身份证号：<s:property value="staff_info.identity_card"/><br>
&nbsp;&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;：<s:property value="staff_info.gender"/><br>
入职时间：<s:date name="staff_info.entry_date" format="yyyy-MM-dd"/><br>
最终学历：<s:property value="staff_info.education"/><br>
家庭住址：<s:property value="staff_info.address"/><br>
联系方式：<s:property value="staff_info.tel"/><br>
&nbsp;&nbsp;&nbsp;Email&nbsp;&nbsp;&nbsp;：<s:property value="staff_info.email"/><br>
<br>

<a href="
    <s:url value="edit_staff.jsp">
        <s:param name="id" value="staff_info.id"/>
        <s:param name="staff_id" value="staff_info.staff_id"/>
        <s:param name="staff_name" value="staff_info.staff_name"/>
        <s:param name="identity_card" value="staff_info.identity_card"/>
        <s:param name="gender" value="staff_info.gender"/>
        <s:param name="entry_date" value="staff_info.entry_date"/>
        <s:param name="education" value="staff_info.education"/>
        <s:param name="address" value="staff_info.address"/>
        <s:param name="tel" value="staff_info.tel"/>
        <s:param name="email" value="staff_info.email"/>
    </s:url>"
        >修改</a>
</body>
</html>
