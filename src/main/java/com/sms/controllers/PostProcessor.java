package com.sms.controllers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.sms.pojo.User;

public class PostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof User) {
			System.out.println("Helo User!! This call from Before init method!!");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof User) {
			System.out.println("Helo User!! This call from After init method!!");
		}
		return bean;
	}

}
