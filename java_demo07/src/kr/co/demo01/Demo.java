package kr.co.demo01;

public class Demo {

	public static void main(String[] args) {
		/*
		 * 상속(Inherit)
		 * 		- 다른 클래스가 가지고 있는 멤버(변수, 메서드)들을
		 * 		  새로 작성하는 클래스에서 직접 만들지 않고 상속을
		 * 		  받아서 자신의 멤버변수, 멤버 메서드처럼 사용할 수 
		 * 		  있게 만드는 기능
		 * 		- 부모의 private 접근제한자를 사용하는 멤버들은 
		 * 		  자식이라해도 접근할 수 없다.
		 * 		- 생성자는 상속되지 않는다.
		 * 		- extends 키워드로 상속받을 수 있는 객체(부모)는 오직 1개 뿐이다.
		 * 		  (다중 상속 지원 안함)
		 * 		- 상속 관계에서 객체가 생성될 때 부모가 먼저 생성된 후 
		 * 		  자식이 생성된다.
		 * 		- 자식 클래스에서 super 키워드를 사용하면 부모에 대한 접근으로
		 * 		  사용된다.
		 * 
		 * 상속의 이점
		 * 		- 재사용성이 높아진다.
		 * 		- 적은 양의 코드로 새로운 클래스 작성
		 * 		- 코드의 중복을 최소화하고 프로그램의 생산성/유지보수성에 기여함
		 * 		- 공통 기능에 대해서는 상속을 통해 관리하기 때문에 관리가 용이해짐
		 * 
		 * 메서드 오버라이드
		 * 	 	- 기존 부모 클래스가 가지고 있는 메서드를 자식에서 재정의하여 사용하는 것.
		 * 	 	- 기존 부모에 정의한 메서드명, 매개변수 타입/수량, 반환타입이 자식도 동일해야 한다.
		 *   	- 메서드 오버라이드 대상에는 @Override 어노테이션을 메서드명 위에 작성한다.
		 *  	  (필수는 아니지만 메서드명에 대한 오타를 확인할 수 있다. 잘못쓰면 오류 뜸!)
		 *   	  (Annotation은 장식자. 메서드 위를 꾸미고 있어서. @를 붙여서 쓰면 됨.)
		 *   	- 접근제한자는 부모의 접근제한자보다 같거나 넓은 범위로 작성해야 한다.
		 *   	- 예외처리: 부모보다 같거나 좁은 범위 또는 적은 수의 예외처리여야 한다.(exception throws)
		 *   	- final 키워드가 사용된 메서드에 대해서는 오버라이드를 할 수 없다.
		 *   	  (final은 상수한테 붙는 것! 메서드에 붙어도 마찬가지로 재정의 할 수 없다.)
		 *   
		 *   오버라이딩과 오버로딩의 비교! 학원 교재에서 확인해 볼 것!(9_상속_12페이지)
		 */   
	 	 
		Student s1 = new Student();
		s1.setName("류호피");
		s1.setAge(20);
		s1.setGender('M');
		s1.setYear(1);
		s1.setClassRoom(1);
		
		System.out.println(s1.getName() + "|" + s1.getAge() + "|" + s1.getYear());
		
		Teacher t1 = new Teacher();
		t1.setName("이환매");
		t1.setAge(25);
		t1.setGender('M');
		t1.setSubject("검술");
		t1.setRole("교장대리");
		
		System.out.println(t1.getName() + "|" + t1.getAge());
		
		s1.addAge();
		t1.addAge(); 
		// 우선권은 자식에 있다. 그런데 자식에 없으면? 부모한테서 찾는다.
		// 그런데 Teacher에는 addAge라는 메서드가 없다! 그러므로 부모인 Person에서 addAge를 찾아 수행한다.
		
		System.out.println(s1.getName() + "|" + s1.getAge() + "|" + s1.getYear());
		System.out.println(t1.getName() + "|" + t1.getAge());
	}

}
