/**
 * 
 */
package com.xedy.springfeatures.annotation.custom.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.xedy.springfeatures.annotation.custom.app.EncapsulatedEvilClass;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xedy_zhang@126.com
 *
 */
@Component
@Slf4j
public class CustomAnnotationBeanPostProcessor implements BeanPostProcessor,ApplicationContextAware {

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.debug("postProcessAfterInitialization -> bean class is : {}",bean.getClass().getName());
		log.debug("bean name is :{}",beanName);
		
		Badboy badboy = AnnotationUtils.findAnnotation(bean.getClass(), Badboy.class);
		log.debug(badboy==null? " NULL " : badboy.value());
		
		List<Map<Field,Annotation>> annotations = getFieldAnnotations(bean.getClass());
		if(!ObjectUtils.isEmpty(annotations))
			for (Map<Field,Annotation> kvMap : annotations) {
				for(Field key : kvMap.keySet()){
					Annotation annotation = kvMap.get(key);
					try {
						String value = (String)(annotation.annotationType().getMethod("value", new Class[]{}).invoke(annotation, new Object[]{}));
						log.debug(value);
						EncapsulatedEvilClass evilClass = new EncapsulatedEvilClass();
						evilClass.setMyName(value);
						
						boolean accessible = key.isAccessible();
						key.setAccessible(true);
						key.set(bean, evilClass);
						key.setAccessible(accessible);
						
					} catch (IllegalArgumentException | IllegalAccessException | SecurityException | InvocationTargetException | NoSuchMethodException e) {
						e.printStackTrace();
					}
				}
			}
		return bean;
	}

	private List<Map<Field,Annotation>> getFieldAnnotations(Class<?> clazz){
		List<Map<Field,Annotation>> annotations=null;
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			Badboy badboy = field.getAnnotation(Badboy.class);
			if(!ObjectUtils.isEmpty(badboy)){
				if(ObjectUtils.isEmpty(annotations))
					annotations = new ArrayList<Map<Field,Annotation>>();
				Map<Field,Annotation> kv = new HashMap<Field,Annotation>();
				kv.put(field, badboy);
				annotations.add(kv);
			}
		}
		return annotations;
	}

	ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
