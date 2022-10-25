package kr.co.demo;

public class Demo04 {

	public static void main(String[] args) {
		/*
		 * 반복문
		 * 		프로그램 수행 흐름을 바꾸는 역할을 하는 제어문 중 하나로
		 * 		특정 문장을 반복해서 수행하도록 한다.
		 * 
		 * 		반복문은 for, while 두 가지의 반복문이 있다.
		 * 
		 * for(초기식; 조건식; 증감식) {
		 * 		반복 수행할 코드 1;
		 * 		반복 수행할 코드 2;
		 * }
		 * 
		 * 초기식 : 변수를 초기화 하기 위한 식이 위치한다. (생략 가능)
		 * 		   반복문이 시작할 때 최초 1회만 동작
		 * 조건식 : 반복문을 계속 수행할지에 대한 조건이 위치한다. (생략 가능)
		 * 		   조건식의 결과가 참이면 반복문 안의 코드 실행
		 * 		   조건식의 결과가 거짓이면 반복문 중단하고 다음 코드로 넘어감
		 * 		   반복문이 시작할 때 뿐만 아니라 반복이 이루어지면 계속 실행
		 * 증감식 : 보통 초기식에서 초기화한 변수의 값을 증감시키기 위해 사용 (생략 가능)
		 * 		   반복문의 마지막 코드가 실행 된 후에 수행하는 코드
		 * 		   반복문이 처음 시작할 때에는 동작하지 않는다.
		 * 
		 * 반복문 안에 break를 사용하면 반복문을 중단할 수 있다.
		 * if문 안에는 break를 사용할 수 없지만, for문 안에 존재하는 if문에는 사용할 수 있다.
		 * 반복문 안에 continue를 사용하면 반복문의 처음으로(증감식)으로 이동한다.
		 */
		
		
		int x1;
		
		for(x1 = 1; x1 <= 3; x1++) {
			System.out.printf("%d 번째 반복\n", x1);
		}
		// 최종적으로 저장된 변수 값은 4이다.
		System.out.println("x1 변수에 저장된 값 -> " + x1);
		
		int x2;
		for(x2 = 1; x2 <= 3; x2++) {
			System.out.printf("%d 번째 반복\n", x2);
		}
		System.out.println("x2 변수에 저장된 값 -> " + x2);
		 
		
		/*
		 * 초기식 생략
		int x3 = 1;
		
		for(; x3 <= 3; x3++) {
			System.out.printf("%d 번째 반복\n", x3);
		 */
		
		/*
		 * 조건식 생략 (break를 안 쓰면 무한반복이 발생하니 조심!)
		int x4 = 1;
		for(;; x4++) {
			System.out.printf("%d 번째 반복\n", x4);
			if(x4 >= 3) {
				break;
		}
		*/
		
		/* 증감식 생략
		int x5 = 1;
		for(; x5 <= 3;) {
			System.out.printf("%d 번째 반복\n", x5);
			x5++;
		}
		*/
		
		/*
		 * 초기식,조건식,증감식 모두 생략하면 무한반복
		for(;;) {
			System.out.println("무한 반복이 필요할 때 사용하세요.");
		}
		*/
		
		/*
		 * 감소하는 형태
		for(int i = 10; i >= 1; i--) {
			System.out.printf("%d\n", i);
		}
		 */
		
		// 중첩 반복
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d X %d = %d\t", j, i, j * i);
											// (\t)는 공백
			}
			System.out.println();
			// 개행(줄바꿈)
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
