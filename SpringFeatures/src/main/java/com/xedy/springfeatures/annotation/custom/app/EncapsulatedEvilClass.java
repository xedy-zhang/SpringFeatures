/**
 * 
 */
package com.xedy.springfeatures.annotation.custom.app;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xedy_zhang@126.com
 *
 */
@Data
@Slf4j
public class EncapsulatedEvilClass {
	
	private String myName;
	
	public byte[] doHack(String question){
		log.trace("doHack 被调用...");
		log.debug("this.myName is : {}",this.myName);
		return (question==null?"the spy program has planted in the target server , wo !":question).getBytes();
	}
}
