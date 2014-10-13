package me.yanaga.ddd.javaee7.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private Ssn ssn;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ssn getSsn() {
		return ssn;
	}

	public void setSsn(Ssn ssn) {
		this.ssn = ssn;
	}
}
