package me.yanaga.ddd.javaee7.view.web;

import me.yanaga.ddd.javaee7.domain.model.Person;
import me.yanaga.ddd.javaee7.domain.model.PersonRepository;
import me.yanaga.ddd.javaee7.domain.model.QPerson;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Stateless
public class PersonController {

	@Inject
	PersonRepository personRepository;

	private Person person = new Person();

	public List<Person> getPeople() {
		QPerson qPerson = QPerson.person;
		return personRepository.findAll();
	}

	public String create() {
		person = new Person();
		return "edit?faces-redirect=true";
	}

	public String edit(Person person) {
		this.person = person;
		return "edit?faces-redirect=true";
	}

	public void remove(Person person) {
		personRepository.delete(person);
	}

	public Person getPerson() {
		return person;
	}

	public String save() {
		personRepository.save(person);
		return "list?faces-redirect=true";
	}

}
