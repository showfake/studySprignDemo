package com.cfs.demo.controller;

import com.cfs.demo.controller.ProxyBeanFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * ClassName: RegisterBeanFactory
 * Description:
 * date: 2022/8/26 21:24
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class RegisterBeanFactory implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(ProxyBeanFactory.class);
		BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, "userDao");
		BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

	}
}
