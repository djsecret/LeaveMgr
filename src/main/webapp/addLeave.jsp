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
    <style>
        .event {
            width: 500px;
            height: 320px;
            background: #fff;
            border: 1px solid #CCC;
            border-radius: 2px;
        }

        .event:before {
            content: '';
            display: block;
            width: 500px;
            height: 300px;
            background: #fff;
            border: 1px solid #CCC;
            border-radius: 2px;
            transform: rotate(5deg);
            position: relative;
            top: 12px;
            left: 2px;
            z-index: -1;
        }


        .event > span {
            display: block;
            width: 50px;
            background: #232323;
            position: relative;
            top: -270px;
            left: -15px;

            /* Text */
            color: #fff;
            font-size: 10px;
            padding: 2px 7px;
            text-align: right;
        }

        .event > .info {
            display: inline-block;
            position: relative;
            top: -275px;
            left: 90px;

            /* Text */
            color: #232323;
            font-weight: 600;
            line-height: 25px;
        }

        .event > .info:first-line {
            text-transform: uppercase;
            font-size: 10px;
            margin: 10px 0 0 0;
            font-weight: 700;
        }

        .event > .price {
            display: inline-block;
            width: 60px;
            position: relative;
            top: -85px;
            left: 115px;

            /* Text */
            color: #E35354;
            text-align: center;
            font-weight: 700;
        }
    </style>
</head>
<body>

    <div class="event">
        <span>请假单</span>

        <div class="info">
            <s:form action="addLeave" namespace="/" theme="simple">
                起始日期: <s:textfield name="leave_info.begin_time"/><br>
                请假天数: <s:textfield name="leave_info.days" size="6"/><br>
                请假事由: <s:textarea name="leave_info.reason" cols="25" rows="5"/> <br>
                <br>
                <span style="float:right;">
                <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重填">
                    </span>
            </s:form>
        </div>

    </div>

</body>
</html>
