package kr.co.demo;

import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {
		/*
		 * 1 부터 시작하여 10 까지 총 10번 반복하는 반복문을 작성하세요.
		 * 출력 메시지는 다음의 형식으로 합니다.
		 * 
		 * 출력 형식
		 * 		총 10번 반복 중 n번 반복
		 * 
		 * n이 1 ~ 10까지 1씩 증가되어서 출력돼야 함
		 */
		for(int a = 1;a <= 10;a++) {
			System.out.printf("총 10번 반복 중 %d번 반복\n", a);
		}
		
		
		/* 
		 * 총 15번 반복하는 반복문을 사용하고 3부터 시작하여 45까지 3의 배수에
		 * 해당하는 값만 출력하는 코드를 작성하시오.
		 */
		for(int b = 1;b <= 15;b++) {
			System.out.printf("%d 번째 반복 -> %d\n", b,b * 3);
		}
		//또는
		for(int b2 = 1, x = 3;b2 <= 15;b2++, x += 3) {
			System.out.printf("%d 번째 반복 -> %d\n", b2, x);
			} 
		
		
		
		/*
		 * 7부터 시작하여 7의 배수에 해당하는 값을 출력할 때 150 이전에 출력되는
		 * 7의 배수 값과 총 반복 횟수를 출력하시오.
		 */
		int cnt = 0;
		for(int i = 7; i < 150; i+=7) {
			cnt += 1;
			System.out.printf("%d 번째 반복 -> %d\n", cnt, i);
		}
		System.out.printf("총 %d 번 반복함", cnt);
		
	
		
	

	}

}
