package kr.co.demo02;

public class Demo {
	
	public static void methodA() throws NegativeArraySizeException { 
		methodB(); // (3) 응 나도 넘김
		// static을 사용했고 Demo 클래스 내부에서 쓰고 있으므로 클래스명.메소드()에서 클래스명 생략.
	}
	
	public static void methodB() throws NegativeArraySizeException { 
		methodC(); // (2) 싫은데ㅋㅋ 나도 넘김
	}
	
	public static void methodC() throws NegativeArraySizeException {
		int arr[] = new int[-1]; // ↑ (1) 예외각 떴네..호출한 위치에 니가 대신 예외처리하라고 떠넘김
	}

	public static void main(String[] args) {
		try { // (4) ㅇㅋ 내가 독박 써서 트라이 캐치 할게 나까지 쓰로우하면 에러나니깐 
			methodA();
		} catch(NegativeArraySizeException e) {
			System.out.println("main에서 에러 처리함.");
		}

	}

}
