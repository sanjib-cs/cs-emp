package com.assignment.cs.emp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 
 * @author sanjib.pramanick
 *
 */
@Component
@PropertySource({ "classpath:db-config.properties" })
public class PropertyResolver {

	@Autowired
	private Environment env;

	public String getProperty(String key) {
		return env.getProperty(key);
	}
}
