package kr.co.exam;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/*
		 * Exam03.java 와 동일한 과정으로 배열을 생성할 때
		 * 중복된 값이 없도록 초기화 하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		int size = 0;
		
		while(!(size >= 2 && size <= 5)) {
			System.out.print("2 ~ 5 사이의 정수 입력 : ");
			size = sc.nextInt();
		}
		
		int arr1[] = new int[size];
		
		for(int i = 0; i < size;) {
			System.out.print("1 ~ 10 사이의 정수 입력 : ");
			int num = sc.nextInt();
			
			if(num >= 1 && num <= 10) {
				boolean 중복이 = false;	// 중복인지 아닌지 판별하기 위한 불린.
				for(int j = 0; j < i; j++) {	// 2번 칸에 입력해야할때 1번 칸까지 중복 체크.
					if(arr1[j] == num) {		// 칸 안의 값이 사용자 입력값과 같느냐?
						중복이 = true;		// 같으면(중복되면) 참으로 기록해라.
						break;					// 이 if 구문을 종료하고 빠져나가라.
					}
				}
				if(!중복이) { // !를 쓴 부정문이기 때문에, "중복이 아니면 실행"으로 해석
						System.out.printf("%d 위치에 %d 값으로 초기화하였습니다.\n", i, num);
						arr1[i] = num;
						i++;
				} else { // 위에서 true였으면(중복값이면) 이 구문을 실행하라.
					System.out.println("이미 초기화된 값입니다.");
				}
			} else {
				System.out.println("값을 다시 확인해서 입력하세요.");
			}
		}
		for(int i = 0; i < size; i++) {
			System.out.printf("%d\t", arr1[i]);
		}

	}

}
