/**
 * 
 */
package com.xedy.springfeatures.annotation.custom;

import java.io.UnsupportedEncodingException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xedy_zhang@126.com
 *
 */
@Slf4j
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
