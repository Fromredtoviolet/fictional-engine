package kr.co.demo03;

public class Demo {

	public static void main(String[] args) {
		// NullPointerException 예시
		String sArr[] = {"A", "B", "C", null, "D", "E"};
		
		for(int i = 0; i < sArr.length; i++) {
			System.out.println(sArr[i].charAt(0)); 
			// 문제해결 1. 오류난 곳에 일단 닷 연산자나 메서드(.length / charAt()) 사용하지 마!
			// 문제해결 2. print(sArr[i]) 로 null이 있는지 확인
			
			/*
			 * Null이 뜨면
			 * 1. 출력 해보세요.
			 * 2. null이 왜 들어갔는지 체크
			 * => 데이터 확인(출력)해서 null이 어디에 있는지 체크
			 */
			
		}
		
		// throw new Exception(); 강제 에러 발생은 throw로 가능
	}

}
