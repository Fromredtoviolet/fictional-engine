package kr.co.demo02;

public class Person {
	private String name;
	private int age;
	private char gender;
	
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
	public boolean equals(Object obj) {
		Person person = (Person)obj;
		
		if(name.equals(person.name)) { // 이름이 같으면 같은 객체로 보게끔.
			return true;
		}
		return false;
	}
	
	// toString 이나 equals는 상단바 소스 메뉴 들어가면 제너레이트~ 하면서 자동생성메뉴 있음

}
