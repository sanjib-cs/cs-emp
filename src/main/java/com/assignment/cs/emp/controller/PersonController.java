package com.assignment.cs.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.cs.emp.bean.Person;
import com.assignment.cs.emp.repo.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Person> findAllPersons() {
		return repository.findAll();
	}

	@RequestMapping(value = "/findByFirstName", method = RequestMethod.GET)
	public List<Person> findByFirstName(@RequestParam String firstName) {
		return repository.findByFirstName(firstName);
	}

	@RequestMapping(value = "/findByLastName", method = RequestMethod.GET)
	public List<Person> findByLastName(@RequestParam String lastName) {
		return repository.findByLastName(lastName);
	}

	@RequestMapping(value = "/findByAge", method = RequestMethod.GET)
	public List<Person> findByAge(@RequestParam Integer age) {
		return repository.findByAge(age);
	}

	@RequestMapping(value = "/deleteByAge", method = RequestMethod.GET)
	public Long deleteByAge(@RequestParam Integer age) {
		return repository.deleteByAge(age);
	}
}
