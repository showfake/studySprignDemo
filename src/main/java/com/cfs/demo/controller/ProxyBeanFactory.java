package com.cfs.demo.controller;

import com.cfs.demo.controller.IUserDao;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ClassName: ProxyBeanFactory
 * Description:
 * date: 2022/8/26 21:19
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class ProxyBeanFactory implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class[] classes = {IUserDao.class};
		InvocationHandler handler = (proxy, method, args) -> "你被代理了 " + method.getName();
		return Proxy.newProxyInstance(classLoader, classes, handler);
	}

	@Override
	public Class<?> getObjectType() {
		return IUserDao.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
