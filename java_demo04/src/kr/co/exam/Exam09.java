package kr.co.exam;

import java.util.Scanner;

public class Exam09 {

	public static void main(String[] args) {
		/* 사용자 입력과 if, for 를 활용하여 사용자로부터 정수값을 입력 받았을 때
		 * 1 ~ 45 사이의 값이 아니면 다시 입력을 받아 1 ~ 45 사이의 값이 저장될
		 * 수 있게 한다. 
		 * (단, 3번의 입력 기회만 부여하고 3번의 기회를 넘기면 0값이 저장되게 한다.)
		 */
		Scanner sc = new Scanner(System.in);
		
		int number = 0;
		for(int i = 1; i <= 3; i++) {
			System.out.print("1 ~ 45 사이의 정수값 입력:");
			int inputNumber = sc.nextInt();
			
			if(inputNumber >= 1 && inputNumber <= 45) {
				number = inputNumber;
				break;
			} else {
				System.out.printf("입력 기회가 %d 번 남았습니다.\n", 3 - i);
			}
		}
		System.out.printf("%d 값이 저장되었습니다.", number);
	

	}

}
