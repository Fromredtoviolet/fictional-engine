package kr.co.Exam;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/*
		 *  사용자 입력을 활용하여 다음의 문제를 풀어보세요.
		 *  
		 *  사용자 입력으로 시, 분, 초를 hour, minute, second 변수에 저장하고
		 *  초로 환산된 결과를 출력하세요.
		 *  
		 *  예시
		 *  	시: 0
		 *  	분: 10
		 *  	초: 20
		 *  
		 *  	총 620 초 입니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시를 입력: ");
		int hour = sc.nextInt(); sc.nextLine();
		
		System.out.print("분을 입력: ");
		int minute = sc.nextInt(); sc.nextLine();
		
		System.out.print("초를 입력: ");
		int second = sc.nextInt(); sc.nextLine();
		
		System.out.println("총 " + ((hour*3600) + (minute*60) + second) + " 초 입니다.");

	}

}
