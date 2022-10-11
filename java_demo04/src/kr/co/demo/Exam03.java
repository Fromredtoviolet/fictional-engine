package kr.co.demo;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if 문을 활용하여 사용자로부터 정수값
		 * 2개를 입력 받았을 때 정수값 0이 있는 경우 나누기 계산에서
		 * 0 으로 나누었을 때 발생하는 오류가 나지 않게 처리하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수값 2개를 입력해주세요.: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// 내 코드
		if(a != 0) {
			if(b != 0) {System.out.println(a / b);
			}
			 else {System.out.println("0은 입력할 수 없습니다.");
			}
		}
		
		// 강사님이 짠 코드
		if (a != 0) {
			System.out.printf("나누기 계산 결과 -> %d 입니다.", a / b);
		} else {
			a = 1;
			System.out.println("0으로 나누기 계산을 할 수 없습니다.");
			System.out.printf("대신 1로 변경하여 계산합니다. -> %d\n", a / b);
		}
	}

}
