package com.spring.aspect;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;

public class FilmListener implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		if(event instanceof  ContextStartedEvent){
			System.out.println("Context Start");
		}else if (event instanceof BeforeInsertFilmEvent) {
			System.out.println("Before Insert Film Data. ");
		}
		else if(event instanceof AfterInsertFilmEvent){
			System.out.println("After Insert Film Data.  ");
		}
		else if(event instanceof ContextClosedEvent){
			System.out.println("Context Stop");
		}
	}

}
