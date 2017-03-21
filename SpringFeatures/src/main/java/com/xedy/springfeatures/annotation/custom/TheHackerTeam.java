/**
 * 
 */
package com.xedy.springfeatures.annotation.custom;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xedy_zhang@126.com
 *
 */
public class TheHackerTeam {
	
	private Logger log = LoggerFactory.getLogger(TheHackerTeam.class);
	
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
