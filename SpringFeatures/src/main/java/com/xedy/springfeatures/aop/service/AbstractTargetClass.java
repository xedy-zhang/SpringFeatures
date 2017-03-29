/**
 * 
 */
package com.xedy.springfeatures.aop.service;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author foresee
 *
 */
@Slf4j
public abstract class AbstractTargetClass {
	private List<String> list = new ArrayList<String>();
	public abstract List<String> doScan();
	public boolean hasNext(){
		log.debug("AbstractTargetClass+++++++++++++++++{}",this.getClass().getName());
		return list.size()>0;
	}
}
