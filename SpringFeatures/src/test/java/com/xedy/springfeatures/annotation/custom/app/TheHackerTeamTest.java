package com.xedy.springfeatures.annotation.custom.app;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TheHackerTeamTest.class})
@ComponentScan(basePackages={"com.xedy.springfeatures.annotation.custom"})
@Slf4j
public class TheHackerTeamTest {

	@Autowired
	TheHackerTeam theHackerTeam;
	
	@Test
	public void test() {
		log.debug("theHackerTeam: {}",theHackerTeam);
		Assert.assertNotNull(theHackerTeam);
		this.theHackerTeam.fakeGreeting("hello");
	}

}
