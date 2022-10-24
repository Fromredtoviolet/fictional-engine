package kr.co.demo01;

public class Person {
	private String name;
	private int age;
	private char gender;
	
	// 부모가 기본 생성자 X인 경우 (아래에 매개변수 있는 생성자를 작성했으므로)
	// 이 때 자식이 기본 생성자를 쓰고 싶다면? super로 부모 호출. (매개변수 있는 생성자 쓰고싶어도 똑같음!)
	// 부모가 기본 생성자 O -> 자식도 super 안 써도 됨.
	// 결론: 부모가 기본 생성자를 작성하는게 편하다.
	public Person(String name) {
		this.name = name;
	}
	
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
	
	/**
	 * 이 메서드를 실행하면 기존 나이에 +1 한 나이가 누적된다.
	 */
	public void addAge() {
		this.age++;
	}
	
	
}
