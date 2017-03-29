/**
 * 
 */
package com.xedy.springfeatures.aop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author foresee
 *
 */
@Service
@Slf4j
public class CalleeClass {
	
	public void hScan(){
		boolean resultBoolean = (new AbstractTargetClass() {
			public List<String> doScan() {
				return new ArrayList<String>();
			}
		}).hasNext();
		log.debug("{} hScan result is : {}",this.getClass().getName(),resultBoolean);
	}
}