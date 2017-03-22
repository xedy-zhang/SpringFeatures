/**
 * 
 */
package com.xedy.springfeatures.annotation.custom.app;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import com.xedy.springfeatures.annotation.custom.core.Badboy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xedy_zhang@126.com
 *
 */
@Slf4j
@Component
public class TheHackerTeam {
	@Badboy("youAreSmartGuy")
	EncapsulatedEvilClass evilClass1;
	
	@Badboy("youAreBadGuy")
	EncapsulatedEvilClass evilClass2;
	
	public void fakeGreeting(String fakeQuestion){
		try {
			String realMessage = new String(evilClass1.doHack(fakeQuestion),"UTF-8");
			log.debug("fakeGreeting call EncapsulatedEvilClass , the result is : {}",realMessage.toUpperCase());
			
			realMessage = new String(evilClass2.doHack("evilClass2 "+fakeQuestion));
			log.debug("fakeGreeting call EncapsulatedEvilClass , the result is : {}",realMessage.toUpperCase());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
