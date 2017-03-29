/**
 * 
 */
package com.xedy.springfeatures.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 * @author foresee
 *
 */
@Component
@Aspect
@Slf4j
@EnableAspectJAutoProxy
public class AspectClass {
	//匿名内部类无法被拦截
	//@Pointcut("execution(* com.xedy.springfeatures.aop.service.CalleeClass$*.hasNext(..))")
	@Pointcut("execution(* com.xedy.springfeatures.aop.service..hScan(..))")
	public void aspect(){}
	
	@Around("aspect()")
	public boolean aroundHasNext(JoinPoint joinPoint){
		//around 类型，将接管目标类的整个实现。
		log.debug(">>>>>>>>>>>aroundHasNext>>>>>>>>>{}",joinPoint.getTarget().getClass());
		return true;
	}
}
