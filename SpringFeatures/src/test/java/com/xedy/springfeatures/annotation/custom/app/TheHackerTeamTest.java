package com.xedy.springfeatures.annotation.custom.app;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

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
	
	@Test
	public void typeConvert(){
		ParentType pt = new ParentType();
		ArrayList list = new ArrayList();
		list.add("parent list");
		pt.setList(list);
		SubclassType st = new SubclassType();
		BeanUtils.copyProperties(pt, st);
		log.debug("the result is : {}",st.getValue());
	}

}

class ParentType{
	private List list;
	public String getValue(){
		return (String)list.get(0);
	}
	public void setList(List list){
		this.list = list;
	}
}

class SubclassType extends ParentType{
	public String getValue(){
		return "subclass's return";
	}
}
