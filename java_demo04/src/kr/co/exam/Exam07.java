package kr.co.exam;

import java.util.Scanner;

public class Exam07 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 사용자가 입력한 정수값만큼 반복을 수행하는 반복문을
		 * 작성하시오. 
		 * (사용자 입력값이 0 이하인 경우 '1 이상의 값을 입력하세요' 라는 메시지를
		 * 출력하고 종료한다.)
		 */
		Scanner sc = new Scanner(System.in);
		
		int d;
		
		System.out.println("정수를 입력하세요. : ");
		d = sc.nextInt();
		
		if(d >= 1) {
			for(int d2 = 1; d2 <= d; d2++) {
				System.out.printf("총 %d 반복중 %d 번째 반복입니다.\n", d, d2);
			}
		} else {
			System.out.println("1 이상의 값을 입력하세요.");
		}
		
	}

}
