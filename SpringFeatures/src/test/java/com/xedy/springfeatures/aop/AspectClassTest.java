package com.xedy.springfeatures.aop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xedy.springfeatures.aop.service.CalleeClass;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AspectClassTest.class})
@ComponentScan(basePackages={"com.xedy.springfeatures.aop"})
@Slf4j
public class AspectClassTest {

	@Autowired
	CalleeClass targetClass;
	
	@Test
	public void testAfterReturning() {
		Assert.assertNotNull(targetClass);
		targetClass.hScan();
		log.debug("test ok ...");
	}
}
