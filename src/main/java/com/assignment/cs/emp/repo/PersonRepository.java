package com.assignment.cs.emp.repo;

import java.util.List;

import org.springframework.data.orient.commons.repository.DetachMode;
import org.springframework.data.orient.commons.repository.annotation.Detach;
import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.graph.repository.OrientGraphRepository;

import com.assignment.cs.emp.bean.Person;

/**
 * 
 * @author sanjib.pramanick
 *
 */
public interface PersonRepository extends OrientGraphRepository<Person> {

  @Override
  @Detach(DetachMode.ALL)
  List<Person> findAll();

  List<Person> findByFirstName(String firstName);

  @Query("select from person where lastName = ?")
  List<Person> findByLastName(String lastName);

  List<Person> findByAge(Integer age);

  Long deleteByAge(Integer age);
}
