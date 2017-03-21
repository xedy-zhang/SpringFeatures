/**
 * 
 */
package com.xedy.springfeatures.annotation.custom.core;

import java.lang.reflect.Method;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.ClassUtils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xedy_zhang@126.com
 *
 */
@Slf4j
@Data
public class CustomAnnotationBeanFactory<T> implements InitializingBean,FactoryBean<T>{
	
	private String targetClassName;
	
	public void afterPropertiesSet() throws Exception {
		log.debug("CustomAnnotationBeanFactory -> afterPropertiesSet .");
	}

	public T getObject() throws Exception {
		log.debug(this.targetClassName);
		Class<?> clazz = ClassUtils.forName(this.targetClassName, this.getClass().getClassLoader());
		if(clazz.isInterface()){
			log.debug("how it can be a interface ....?");
		}else{
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(clazz);
			enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
			enhancer.setCallback(new CustomMethodInterceptor());
			return (T) enhancer.create();
		}
		return null;
	}

	public Class<?> getObjectType() {
		try {
			log.debug("targetClassName is : {}",this.targetClassName);
			return (Class<?>)ClassUtils.forName(this.targetClassName, this.getClass().getClassLoader()).getClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (LinkageError e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isSingleton() {
		return true;
	}
}

class CustomMethodInterceptor implements MethodInterceptor{

	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		return arg3.invokeSuper(arg0, arg2);
	}
	
}