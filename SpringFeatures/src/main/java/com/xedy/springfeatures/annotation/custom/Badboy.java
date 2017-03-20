/**
 * 
 */
package com.xedy.springfeatures.annotation.custom;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(FIELD)
public @interface Badboy {
	public String value() default "";
}