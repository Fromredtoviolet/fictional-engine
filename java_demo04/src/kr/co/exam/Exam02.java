package kr.co.exam;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if 문을 활용하여 사용자로부터 정수값을
		 * 입력 받았을 때 5의 배수 값만 출력하게 하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		// 내 코드
		System.out.println("정수값 입력: ");
		int a = sc.nextInt();
		
		if(a % 5 ==0) {
			System.out.println(a);
		}
		System.out.println("프로그램이 종료됩니다.");
		
		// 강사님이 짠 코드
		if(a % 5 == 0) {
			System.out.printf("사용자가 입력한 값 %d 는 5의 배수가 맞습니다.", a);
		}

	}

}
