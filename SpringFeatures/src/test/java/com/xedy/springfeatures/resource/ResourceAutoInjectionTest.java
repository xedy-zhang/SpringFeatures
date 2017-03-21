/**
 * 
 */
package com.xedy.springfeatures.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xedy_zhang@126.com
 *
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ResourceAutoInjectionTest.class})
@ComponentScan
public class ResourceAutoInjectionTest implements ApplicationContextAware{
	
	@Autowired
	ResourceAutoInjection resourceAutoInjection;
	
	@Test
	public void test(){
		log.debug(resourceAutoInjection.toString());
		resourceAutoInjection.printResources();
		log.debug("测试进行时……");
	}

	ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
