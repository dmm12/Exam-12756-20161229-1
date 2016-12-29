package com.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.serviceImpl.FilmServiceImpl;

public class SpringTest {

	private AbstractApplicationContext context;

	public SpringTest() {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		context.start();
		FilmServiceImpl fiImpl = (FilmServiceImpl) context.getBean("filmService");
		int index =fiImpl.insert();
		if(index ==1 ){
			context.close();
		}
	}
	public static void main(String[] args) {
		new SpringTest();
	}
}
