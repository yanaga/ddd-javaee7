package me.yanaga.ddd.javaee7;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

	@Produces
	@PersistenceContext
	private EntityManager entityManager;

}
