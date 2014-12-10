package com.neu.common;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;


public class LoginInterceptor extends AbstractInterceptor
{
    @Override
    public String intercept(ActionInvocation invocation) throws Exception
    {

        Map map = invocation.getInvocationContext().getSession();

        if(null == map.get(Constant.STAFF_LOGIN))
        {
            return Action.LOGIN;
        }

        return invocation.invoke();

    }
}
