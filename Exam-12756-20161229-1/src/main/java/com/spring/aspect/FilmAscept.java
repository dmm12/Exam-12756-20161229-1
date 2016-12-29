package com.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


@Aspect
public class FilmAscept implements ApplicationContextAware {

	private ApplicationContext ctx = null;

	public ApplicationContext getCtx() {
		return ctx;
	}
	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}
@Pointcut("execution(* com.spring.mapper.*.*(..))")
//public void myPoint(){}

//@	Before(value="myPoint()")//前置通知
public void doBefore(){
	BeforeInsertFilmEvent  beforeInsertFilmEvent= new BeforeInsertFilmEvent(ctx);
	ctx.publishEvent(beforeInsertFilmEvent );
}

//@After(value="myPoint()")//后置通知
public void doAfter(){
	AfterInsertFilmEvent afterInsertFilmEvent = new AfterInsertFilmEvent(ctx);
	ctx.publishEvent(afterInsertFilmEvent );
}

@Override
public void setApplicationContext(ApplicationContext event) throws BeansException {
	// TODO Auto-generated method stub
	this.ctx = event;
}

}
