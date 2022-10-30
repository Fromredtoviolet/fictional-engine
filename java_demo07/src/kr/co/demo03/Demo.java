package kr.co.demo03;

public class Demo {

	public static void main(String[] args) {
		/*
		 * 다형성
		 *		- 객체 지향 프로그램 언어의 3가지 특징(캡슐화, 상속, 다형성) 중 하나
		 * 		- 하나의 객체가 여러 형태를 객체로 사용할 수 있음을 의미
		 * 		- 상속을 사용하여 부모 타입으로부터 파생된 여러 타입의 자식 객체를
		 * 		  부모 클래스로 다룰수 있게 된다. (부모도 자식꺼를 쓴다!)
		 * 		- 부모 클래스가 상속한 멤버필드/메서드에 대해서만 다룰 수 있다.
		 * 		  자식 클래스에 개별적으로 작성된 필드/메서드는 사용할 수 없다.
		 * 
		 * 원래는 이렇게 썼었다.
		 * 		자료형 변수명 = 리터럴값;
		 * 		객체타입 변수명 = new 객체타입();
		 * 다형성 개념을 적용해서 인스턴스를 만들면 이렇다.
		 * 		부모객체타입 변수명 = new 자식객체타입();
		 */
		Person p1 = new Customer();			// 업캐스팅이란 이런 것.
		Person p2 = new VipCustomer();		// 자식들을 부모로 씀
		
		p1.setName("홍길동");
		p1.setAge(23);
		p1.setGender('M');
		
		p2.setName("홍길동동");
		p2.setAge(24);
		p2.setGender('M');
		
		System.out.println(p1);
		System.out.println(p2);
		
		/*
		 * 다운 캐스팅
		 * 		- 부모 객체로 사용하고 있는 인스턴스를 자식 객체로 변환하는 것
		 * 		- 명시적으로 작성하여 캐스팅이 이루어지게 한다.(캐스팅 연산 사용)
		 * 		
		 * 업 캐스팅
		 * 		- 자식 객체로 사용하고 있는 인스턴스를 부모 객체로 변환하는 것
		 * 		- 자동으로 변환이 이루어진다.
		 */
		Customer c1 = (Customer)p1;
		VipCustomer v1 = (VipCustomer)p2;
		
		c1.setDiscount(0.05);	// 값 변경도 이렇게 여기서 해줄수있다구~
		v1.setDiscount(0.15);
		System.out.println(c1.getDiscount());
		System.out.println(v1.getDiscount());
		System.out.println(v1.getPoint());
		
		System.out.println(p1);
		System.out.println(p2);
		
		/*
		 * 배열에 다형성을 적용하여 서로 다른 자식 객체를 담아 사용할 수 있다.
		 */
		Person pArr[] = new Person[4];
		pArr[0] = new Customer();
		pArr[1] = new VipCustomer();
		pArr[2] = new VipCustomer();
		pArr[3] = new Customer();
		
		pArr[0].setName("이환매");
		pArr[1].setName("유난오");
		pArr[2].setName("박국영");
		pArr[3].setName("서죽경");
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i]);
		}
		
		for(int i = 0; i < pArr.length; i++) {
			if(pArr[i] instanceof VipCustomer) {	// instanceof 연산자
			VipCustomer vip = (VipCustomer)pArr[i];
			System.out.println(vip.getName() + "|" + vip.getPoint());
			}
		}
				
	

	}

}
