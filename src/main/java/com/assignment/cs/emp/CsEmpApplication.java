package com.assignment.cs.emp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.assignment.cs.emp.bean.Person;
import com.assignment.cs.emp.repo.PersonRepository;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

/**
 * 
 * @author sanjib.pramanick
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan("com.assignment.cs.emp")
@EnableOrientRepositories("com.assignment.cs.emp.repo")
@SpringBootConfiguration
public class CsEmpApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private OrientObjectDatabaseFactory factory;
	
	

	public static void main(String[] args) {
		SpringApplication.run(CsEmpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {/*
		
	    OObjectDatabaseTx db = null;

	    try {
	      db = factory.openDatabase();
	      db.getEntityManager().registerEntityClasses("com.assignment.cs.emp.bean");
	    } finally {
	      if (db != null) {
	        db.close();
	      }
	    }

	    //Create Persons if required
	    if (repository.count() < 1) {
	      List<Person> persons = new ArrayList<Person>();

	      Person graham = new Person();
	      graham.setFirstName("Graham");
	      graham.setLastName("Jacobson");
	      graham.setAge(25);

	      persons.add(graham);

	      Person ebony = new Person();
	      ebony.setFirstName("Ebony");
	      ebony.setLastName("Irwin");
	      ebony.setAge(21);

	      persons.add(ebony);

	      Person benedict = new Person();
	      benedict.setFirstName("Benedict");
	      benedict.setLastName("Preston");
	      benedict.setAge(25);

	      persons.add(benedict);

	      Person zorita = new Person();
	      zorita.setFirstName("Zorita");
	      zorita.setLastName("Clements");
	      zorita.setAge(23);

	      persons.add(zorita);

	      Person kaitlin = new Person();
	      kaitlin.setFirstName("Kaitlin");
	      kaitlin.setLastName("Walter");
	      kaitlin.setAge(22);

	      persons.add(kaitlin);

	      repository.save(persons);
	    }
	  */}
}
