package kr.co.demo;

public class Demo05 {

	public static void main(String[] args) {
		/*
		 * while 반복문
		 * 
		 * while(조건식) {
		 * 		실행 코드;
		 * }
		 * 
		 * 조건식의 결과 값이 참일 때 반복을 수행하며, 거짓이 되면
		 * 반복을 중단한다.
		 * 
		 * break, continue 를 사용하여 반복문을 제어할 수 있다.
		 * 
		 */
		
		int i = 0; 					// 초기식
		while(i < 5) { 				// 조건식
			System.out.println(i);
			i++; 					// 증감식
		}
		
		// 무한 반복문
		while(true) {
			System.out.println("무한 반복");
			break;
		}
		
		/*
		 *  do while 반복문
		 *  		일단 1회 반복을 수행 후 조건식의 결과에 따라 참이면 반복을 계속 진행.
		 *  		거짓이면 반복 중단
		 *  
		 *  do {
		 *  	실행 코드
		 *  } while(조건식);
		 */
		
		do {
			System.out.println("조건식의 결과가 거짓이어도 일단 1회를 실행함.");
		} while(false);
		
		
		
		// for문을 while문으로 바꿔보는 연습 (Exam06파일에서 가져옴)
		int a = 1;
		while(a <= 10) {
			System.out.printf("총 10번 반복 중 %d번 반복\n", a);
			a++;
		}
		
		int b = 1;
		while(b <= 15) {
			System.out.printf("%d 번째 반복 -> %d\n", b,b * 3);
			b++;
		}
		
		int cnt = 0;
		int c = 7; 
		while(c < 150) { 
			cnt += 1;
			System.out.printf("%d 번째 반복 -> %d\n", cnt, c);
			c+=7;
		}
		System.out.printf("총 %d 번 반복함", cnt);
	}

}
