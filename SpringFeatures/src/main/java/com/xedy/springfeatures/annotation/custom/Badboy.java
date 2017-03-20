/**
 * 
 */
package com.xedy.springfeatures.annotation.custom;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@Documented
@Target(FIELD)
/**
 * @author xedy_zhang@126.com
 *
 */
public @interface Badboy {
	public String value="";
}