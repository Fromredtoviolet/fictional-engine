package kr.co.exam;

public class Exam10 {

	public static void main(String[] args) {
		/*
		 * 1부터 시작하여 31까지 출력하기 위한 출력 구문을 만든다.
		 * 단, 달력처럼 1줄에 7개의 값이 출력되어야 합니다.
		 * (반드시 중첩 for문을 사용할 필요는 없음)
		 */
		
		for(int x = 1;x <= 31; x++) {
			System.out.printf("%d\t", x);
			if(x % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println(); 
		
		// 또는 중첩 반복문을 사용하면
		for(int i = 1; i <= 5; i++) {
			int day = 0;
			for(int j = 1; j <= 7; j++) {
				day = 7 * (i - 1) + j;
				System.out.printf("%d\t", day);
				if(day >= 31) {
					break;
					}
				}
			System.out.println();
			if(day >= 31) {
				break;
			}
		}
			
			
		
		/*
		 * 다음과 같은 출력이 나오도록 하시오. (중첩 for를 사용하세요.)
		 * 
		 * 1
		 * 2	3
		 * 4	5	6
		 * 7	8	9	10
		 * 11	12	13	14	15
		 */
		// 1열에는 1개, 2열에는 2개, 3열에는 3개...
		/*
		for(int i = 1;i <= 15;i++) {
			for(int j = 1;j <= 5;j++) {
				System.out.printf("%d\t", i);
				System.out.println();
			}
			*/
		}

	}


