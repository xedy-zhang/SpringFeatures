/**
 * 
 */
package com.xedy.springfeatures.annotation.custom.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xedy_zhang@126.com
 *
 */
@Component
@Slf4j
public class CustomAnnotationBeanFactoryPostProcessor implements BeanFactoryPostProcessor, ApplicationContextAware {

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		for (String name : beanFactory.getBeanDefinitionNames()) {
			log.debug("--------------- : {}",name);
		}
		log.debug("++++++++++++++++++++++++++++++++++++++++");
		CustomAnnotationScanner customAnnotationScanner = new CustomAnnotationScanner((BeanDefinitionRegistry)beanFactory);
		customAnnotationScanner.setResourceLoader(applicationContext);
		customAnnotationScanner.scan("com.xedy.springfeatures.annotation.custom.app");
	}

	private ApplicationContext applicationContext;
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
