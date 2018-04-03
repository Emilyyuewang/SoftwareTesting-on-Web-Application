package edu.umd.fcmd.guice.application;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingInterceptor implements MethodInterceptor{
	public Object invoke(MethodInvocation mi) throws Throwable{
		System.out.println("enter:"+mi.getMethod().getName());
		try{
			return mi.proceed();
		}
		finally{
			System.out.println("exit:"+mi.getMethod().getName());
		}
	}
}
