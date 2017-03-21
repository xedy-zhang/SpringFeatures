/**
 * 
 */
package com.xedy.springfeatures.annotation.custom;

/**
 * @author xedy_zhang@126.com
 *
 */
public class EncapsulatedEvilClass {
	
	public byte[] doHack(String question){
		return (question==null?"the spy program has planted in the target server , wo !":question).getBytes();
	}
}
