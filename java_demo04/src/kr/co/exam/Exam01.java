package kr.co.exam;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if 문을 활용하여 사용자로부터 정수값을
		 * 입력 받았을 때 1 ~ 45 사이의 값만 출력하게 하세요.
		 */

		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력: ");
		int a = sc.nextInt();  
		
		// 내 코드
		if(a > 0) {
			if(a < 46) {
			System.out.println(a);
			} else {
				System.out.println("프로그램이 종료됩니다.");
			}
		}
		
		// 강사님이 짠 코드 1
		if(a >=1 && a<= 45) {
			System.out.printf("사용자가 입력한 값 -> %d", a);
		}
		// 강사님이 짠 코드 2
		if(a >= 1) {
			if(a <= 45) {
				System.out.printf("사용자가 입력한 값 -> %d", a);
			}
		}
		
	}

}
