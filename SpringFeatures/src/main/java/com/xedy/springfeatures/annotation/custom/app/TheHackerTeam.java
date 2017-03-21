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
	EncapsulatedEvilClass evilClass;
	
	public void fakeGreeting(String fakeQuestion){
		try {
			String realMessage = new String(evilClass.doHack(fakeQuestion),"UTF-8");
			log.debug(realMessage.toUpperCase());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
