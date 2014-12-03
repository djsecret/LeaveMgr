package com.neu.common;

import com.neu.pojo.Staff_Job;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;


public class LoginInterceptor extends AbstractInterceptor
{
    @Override
    public String intercept(ActionInvocation invocation) throws Exception
    {

        System.out.println("LoginInterceptor");
        Map map = invocation.getInvocationContext().getSession();

        if(null == map.get(Constant.STAFF_LOGIN))
        {
            System.out.println("did not login");
            return Action.LOGIN;
        }

        Staff_Job staff_job = (Staff_Job)map.get(Constant.STAFF_LOGIN);
        System.out.println(staff_job.toString());
        System.out.println("had login");
        return invocation.invoke();

    }
}
