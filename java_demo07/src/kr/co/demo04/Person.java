package kr.co.demo04;

import java.util.Objects;

public abstract class Person { // 추상 클래스로 쓰려고 만들었다~~
	
	private String name;
	private int age;
	private char gender;
	
	public abstract String getFirstName(); // 선언만 있고 코드 구현부(몸체)가 없는 메서드
	public abstract String getLastName(); // 선언만 있고 코드 구현부(몸체)가 없는 메서드
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, gender, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && gender == other.gender && Objects.equals(name, other.name);
	}

}
