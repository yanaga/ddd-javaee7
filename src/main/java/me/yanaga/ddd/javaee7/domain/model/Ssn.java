package me.yanaga.ddd.javaee7.domain.model;

import com.google.common.base.Strings;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;

public class Ssn implements Serializable {

	private final String value;

	private Ssn(String value) {
		this.value = value;
	}

	public static Ssn of(String value) {
		checkArgument(!Strings.isNullOrEmpty(value));
		checkArgument(value.matches("\\d{3}"));
		return new Ssn(value);
	}

	@Override
	public String toString() {
		return value;
	}

}
