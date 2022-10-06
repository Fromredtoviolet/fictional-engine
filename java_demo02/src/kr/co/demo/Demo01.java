package kr.co.demo;

public class Demo01 {

	public static void main(String[] args) {
		// 변수 : 컴퓨터 메모리에 값(데이터)를 저장하기 위한 공간
		//		 변수 공간에 저장된 값을 쉽게 사용하기 위해 변수에는 
		//		 이름이 부여되어야 한다. -> '변수명'
		
		// 변수명에는 작명규칙이 있기 때문에 해당 규칙에 맞게 작성해야 한다.
		// 1. 영문자, 숫자, 한글, 특수문자(_, $) 만 사용할 수 있다.
		// 2. 숫자로 시작하면 안된다.
		// 3. 공백이 있으면 안된다.
		// 4. 예약어를 사용하면 안된다. (이클립스에서 하이라이트 처리하는 단어)
		// 5. 소문자, 대문자 구분을 한다. (a와 A는 다른 것으로 취급)
		
		// 변수 작명 규칙 옵션 -> 관습적으로 굳어진 규칙
		// 1. 변수명은 소문자로 작성한다.
		// 2. 변수명은 의미 있는 단어로 작성한다.
		// 3. 의미있는 단어의 조합으로 작성하는 경우, 
		//	  2번째 단어부터는 첫번째 문자는 반드시 대문자로 작성한다.
		//	-> 카멜케이스(Camel Case) 방식. 예: myName
		
		// 자료형
		// 1. 정수
		//		- 1 바이트 크기 정수 -> byte
		//		- 2 바이트 크기 정수 -> short
		//		- 4 바이트 크기 정수 -> int
		//		- 8 바이트 크기 정수 -> long
		// 2. 실수
		//		- 4 바이트 크기 실수 -> float
		//		- 8 바이트 크기 실수 -> double
		// 3. 문자
		//		- 2 바이트 크기 문자 -> char
		// 4. 문자열
		//		- 참조형 -> String
		// 5. 불린
		//		- 1 바이트 크기 불린 -> boolean
		
		short s1 = 65;  // 00000000 01000001 (65를 2진수로 표기)
		char c1 = 65;   // 00000000 01000001 (65를 2진수로 표기)
		
		// 컴퓨터는 입력된 2진수의 값이 숫자 65인지, 문자 A인지 알수없으므로
		// short이나 char라는 자료형으로 구분해주는 것.
		
		System.out.print(s1);
		System.out.print(c1);
		
		// 변수 선언
		int i1;
		
		// 선언한 변수에 데이터 할당(저장, 초기화)
		i1 = 10;
		
		// 이미 초기화한 변수에 데이터 재할당
		i1 = 20;
		System.out.print(i1);
		
		// 변수 선언 후 즉시 초기화
		int i2 = 30;
		System.out.print(i2);
		
		// 변수 선언만 하고 초기화하지 않은 경우 -> 에러 발생
		// int i3;
		// System.out.print(i3);
		
		// 다양한 자료형을 사용하여 변수에 데이터 저장
		byte by1 = 127;  // 2^7 - 1
		byte bt2 = -128; // -2^7 - 1
		
		short st1 = 32767;
		short st2 = -32768;
		
		int it1 = 2147483647;
		int it2 = -2147483648;
		
		long lg1 = 9223372036854775807L;
		long lg2 = -9223372036854775808L;
		
		float ft1 = 0.3f;
		float ft2 = .3f; // 소수점 앞이 0일 경우 생략 가능
		
		double db1 = 0.3;
		double db2 = .3;
		
		char cr1 = 65; // 정수로 작성해도 됨
		char cr2 = 'A'; // '작은 따옴표'로 할당
		
		boolean b1 = true;
		boolean b2 = false;
		
		String st3 = "ABCD"; // "큰 따옴표"로 할당

	}

}
