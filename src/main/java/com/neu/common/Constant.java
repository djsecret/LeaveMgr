package com.neu.common;


public class Constant
{
    public static final int DAYS_THRESHOLD = 2;
    /*key put into session*/
    public static final String STAFF_LOGIN = "staff_login";
    public static final String UNREAD_MESSAGE_NUM = "unread_message_number";

    /*duty*/
    public static final int DUTY_GENERAL_MANAGER = 1;
    public static final int DUTY_MINISTER = 3;

    /*message*/
    public static final String MESSAGE_LEAVE_NAME = "请假单";
    public static final String MESSAGE_DELIVER_NAME = "转交请假单";
    public static final String MESSAGE_ALLOW_NAME = "请假申请通过";
    public static final String MESSAGE_REJECT_NAME = "请假申请未通过";
    public static final String MESSAGE_RESUMPTION_NAME = "销假申请";
    public static final String MESSAGE_ARCHIVE_NAME = "销假成功";

    public static final String MESSAGE_ALLOW_CONTENT = "恭喜，您的请假申请已经通过！";
    public static final String MESSAGE_REJECT_CONTENT = "抱歉，您的请假申请没有通过！";
    public static final String MESSAGE_ARCHIVE_CONTENT = "销假成功，已归档！";

    public static final int MESSAGE_COMMUNICATION_TYPE = -1;
    public static final int MESSAGE_LEAVE_APPLY_TYPE = 0;
    public static final int MESSAGE_LEAVE_ALLOW_TYPE = 1;
    public static final int MESSAGE_LEAVE_REJECT_TYPE = 2;
    public static final int MESSAGE_LEAVE_RESUMPTION_TYPE = 3;
    public static final int MESSAGE_LEAVE_ARCHIVE_TYPE = 4;
    public static final int MESSAGE_LEAVE_DELIVER_TYPE = 5;

    public static final int MESSAGE_UNREAD_FLAG = 1;
    public static final int MESSAGE_READ_FLAG = 0;

    /*leave_info*/
    public static final int LEAVE_INFO_INVALID = 0;
    public static final int LEAVE_INFO_VALID = 1;

    public static final int LEAVE_INFO_REJECT_RESULT = 0;
    public static final int LEAVE_INFO_ALLOW_RESULT = 1;
    public static final int LEAVE_INFO_RESUMPTION_RESULT = 2;
    public static final int LEAVE_INFO_ARCHIVE_RESULT = 3;
    public static final int LEAVE_INFO_ALLPY_RESULT = 4;
    public static final int LEAVE_INFO_DELIVER_RESULT = 5;



}
