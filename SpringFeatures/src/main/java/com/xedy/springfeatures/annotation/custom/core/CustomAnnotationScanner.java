/**
 * 
 */
package com.xedy.springfeatures.annotation.custom.core;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xedy_zhang@126.com
 *
 */
@Slf4j
public class CustomAnnotationScanner extends ClassPathBeanDefinitionScanner {

	public CustomAnnotationScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}
	
	@Override
	protected void registerDefaultFilters() {
		log.debug("register default filters .. ");
		this.addIncludeFilter(new AnnotationTypeFilter(Badboy.class));
	}
	
	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		log.debug("do scan basePackages : {}",basePackages);
		Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
			GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition)beanDefinitionHolder.getBeanDefinition();
			genericBeanDefinition.getPropertyValues().add("targetClassName", genericBeanDefinition.getBeanClassName());
			genericBeanDefinition.setBeanClass(CustomAnnotationBeanFactory.class);
		}
		return beanDefinitionHolders;
	}
	
	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return super.isCandidateComponent(beanDefinition) && beanDefinition.getMetadata().hasAnnotation(Badboy.class.getName());
	}
}
