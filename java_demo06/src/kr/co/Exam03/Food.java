package kr.co.Exam03;

public class Food {
	public String name;
	public int price;
	
	public Food(String name) {
		this.name = name;
	}
	
	public Food(String name, int price) {
		this(name); // 매개변수가 name인 생성자. 생성자는 반드시 첫번째 줄에 있는 것이 규칙.
		this.price = price;
		
		// this란 무엇인가?
		// 반드시 써야하는건 아니지만, 만약 쓰지 않았을 때 name=name;이라 적혀있다면,
		// 프로그램 입장에서는 이 name이 멤버변수인지 지역변수인지 구분하기 어렵다.
		// 그러므로 인스턴스 객체에 자기자신이라는 의미로 this를 붙여 구분하는 것이다.
	} 
}
