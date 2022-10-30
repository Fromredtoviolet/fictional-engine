package kr.co.demo03;

import kr.co.demo03.customer.*; // .*은 모든 클래스를 지칭. 지정하려면 Customer2라고 콕 집어줘야함

public class Demo {

	public static void main(String[] args) {
		/*
		 * 접근제한자
		 * 		public : 모든 영역에서 접근 가능함
		 * 		protected : 동일 패키지 또는 후손 관계까지만 접근 가능
		 * 		(default) : 동일 패키지까지만 접근 가능, 명시하지 않는다.
		 * 		private : 해당 클래스 내부에서만 접근 가능
		 * 
		 * 클래스 접근제한자
		 * 		public, (default)
		 * 
		 * 멤버 변수 
		 * 		public, protected, (default), private
		 * 
		 * 멤버 메서드
		 * 		public, protected, (default), private
		 * 
		 * 접근제한자 아이콘!
		 * 		퍼블릭: 초록색 동그라미
		 * 		프로텍티드 : 노란 마름모
		 * 		디폴트 : 파란 세모
		 * 		프라이빗 : 빨간 네모
		 * 		파이널 : F 붙음
		 * 		스태틱 : S 붙음
		 * 		파이널 스태틱 : SF 붙음
		 * 		앱스트랙트 : A 붙음
		 */
		
		Customer1 cs1 = new Customer1(); // 같은 패키지이므로 가능
		cs1.name = "홍길동";
		cs1.age = 32;
//		cs1.phone = "010-1234-5678";
		
		Customer2 cs2 = new Customer2(); // 다른 패키지이므로 불가능. 상단에 import문 넣어줘야함
		cs2.name = "홍길동";
//		cs2.age = 32;
//		cs2.phone = "010-1234-5678";
		
		

	}

}
