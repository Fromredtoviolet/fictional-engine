package kr.co.demo;

import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		
		// 1. 년도 값을 입력 받아 해당 년도가 윤년인지 아닌지 구하세요.
		//	  윤년의 규칙은 다음과 같습니다.
		//	  - 윤년은 4의 배수입니다.
		//	  - 4의 배수이면서 100의 배수이면 윤년이 아닙니다.
		//    - 4, 100, 400의 배수에 해당하면 윤년입니다.
		
		Scanner sc = new Scanner(System.in);
		
		int year;
		String message = "";
		
		System.out.print("년도 입력 : ");
		year = sc.nextInt();
		
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					message = "%d 년은 윤년입니다.";
				} else {
					message = "%d 년은 윤년이 아닙니다.";
				}
			} else {
				message = "%d 년은 윤년입니다.";
			}
		} else {
			message = "%d 년은 윤년이 아닙니다.";
		}
		System.out.printf(message, year);
		System.out.println();
		
		// 2. 2022년 10월 달력을 참고하여 사용자가 입력한 일자가 무슨 요일인지 출력하세요.
		// 예시
		//	일자: 10
		//  월요일 입니다.
		
		int day;
		
		System.out.print("일자 : ");
		day = sc.nextInt();
		
		/*
		if(day % 7 ==0) {
			message = "금";
		} else if(day % 7 == 1) {
			message = "토";
		} else if(day % 7 == 2) {
			message = "일";
		} else if(day % 7 == 3) {
			message = "월";
		} else if(day % 7 == 4) {
			message = "화";
		} else if(day % 7 == 5) {
			message = "수";
		} else if(day % 7 == 6) {
			message = "목";
		}
		*/
		
		switch(day % 7) {
		case 0:
			message = "금"; break;
		case 1:
			message = "토"; break;
		case 2:
			message = "일"; break;
		case 3:
			message = "월"; break;
		case 4:
			message = "화"; break;
		case 5:
			message = "수"; break;
		case 6:
			message = "목"; break;
		}
			
		System.out.printf("%s요일 입니다.", message);

	}

}
