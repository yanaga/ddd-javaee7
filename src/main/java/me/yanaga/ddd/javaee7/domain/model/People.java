package me.yanaga.ddd.javaee7.domain.model;

import com.mysema.query.types.expr.BooleanExpression;

public class People {

	public static BooleanExpression withSsn(Ssn ssn) {
		return QPerson.person.ssn.eq(ssn);
	}

	public static BooleanExpression withName(String name) {
		return QPerson.person.name.containsIgnoreCase(name);
	}

}
