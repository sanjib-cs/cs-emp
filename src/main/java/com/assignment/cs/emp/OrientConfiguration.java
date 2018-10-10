package com.assignment.cs.emp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.OrientObjectTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;

/**
 * 
 * @author sanjib.pramanick
 *
 */
@Configuration
@EnableTransactionManagement
@EnableOrientRepositories(basePackages = "com.assignment.cs.emp.bean")
public class OrientConfiguration {

	@Bean
	public OrientObjectDatabaseFactory factory() {
		OrientObjectDatabaseFactory factory = new OrientObjectDatabaseFactory();

		factory.setUrl("remote:localhost/emp");
		factory.setUsername("root");
		factory.setPassword("pass@123");
		factory.setMaxPoolSize(10);

		return factory;
	}

	@Bean
	public OrientTransactionManager transactionManager() {
		return new OrientTransactionManager(factory());
	}

	@Bean
	public OrientObjectTemplate objectTemplate() {
		return new OrientObjectTemplate(factory());
	}

	private OrientGraphFactory initializeOrientGraphFactory() {
		return new OrientGraphFactory("remote:localhost/emp").setupPool(1, 10);
	}

	@Bean(name = "orientGraph")
	public OrientGraph getOrientGraph() {
		return initializeOrientGraphFactory().getTx();
	}

}
