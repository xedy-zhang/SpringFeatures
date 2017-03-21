/**
 * 
 */
package com.xedy.springfeatures.annotation.custom.parse;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @author xedy_zhang@126.com
 *
 */
public class CustomAnnotationScanner extends ClassPathBeanDefinitionScanner {

	public CustomAnnotationScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}
	
}
