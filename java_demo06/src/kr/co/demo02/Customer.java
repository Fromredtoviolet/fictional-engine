package kr.co.demo02;

public class Customer {
	String name;
	int age;
	String phone;
	String address;
	
	// 기본 생성자
	public Customer() {}
	
	// 매개변수가 있는 생성자		
	public Customer(String name) {
		this.name = name;
	}
	
	// 매개변수가 있는 생성자
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
		// ↓여기 이 void가 반환 타입
	public void pay() { }
	
	public void payCancel() { }
	
	public void phoneChange() { }

}
