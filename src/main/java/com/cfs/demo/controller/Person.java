package com.cfs.demo.controller;

import java.util.Objects;

/**
 * ClassName: Person
 * Description:
 * date: 2022/8/11 21:05
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class Person {

	String age;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(age, person.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(age);
	}
}
