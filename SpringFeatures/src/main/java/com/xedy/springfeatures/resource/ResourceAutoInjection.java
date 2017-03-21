/**
 * 
 */
package com.xedy.springfeatures.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xedy_zhang@126.com
 *
 */
@Slf4j
@Service
@PropertySource(value={"classpath:/${base.path:config/mongo}/a.properties"})
public class ResourceAutoInjection {
	
	@Value("${findAll}")
	String command;
	
	public void printResources(){
		log.debug("mongo command line . {}",this.command);
	}
}
