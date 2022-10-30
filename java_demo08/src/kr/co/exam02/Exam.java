package kr.co.exam02;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 사용자 입력으로 전화번호를 입력 받고 입력 받은 전화번호의
		 * 일부 내용을 숨겨서 출력하기 위한 기능을 구현하세요.
		 *	 1. 전화번호 형식은 반드시 010 으로 시작하는 문자열이어야 합니다.
		 *	 2. - 으로 구분된 전화번호 형식이 입력되어야 합니다.
		 *	 3. 전화번호의 2번째 3번째 번호는 반드시 4자리여야 합니다.
		 *	 4. 사용자가 입력한 전화번호는 출력할 때 일부 내용이 숨김 처리되어야 합니다.
		 *		 입력 : 010-1234-5678
		 *		 출력 : 010-1234-****
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("전화번호를 입력해주세요. : ");
		int num = sc.nextInt();
		String str = String.valueOf(num);
		
		boolean isStarts = str.startsWith("10");
		if(isStarts) {
			String start = "0";
			str = start.concat(str);
			String str1 = str.substring(0, 3);
			String str2 = str.substring(3, 7);
			String str3 = str.substring(7, 11);
			str = String.join("-", str1, str2, "****");
			System.out.println(str);
		} else {
			System.out.println("010으로 시작하는 번호를 입력해주세요.");
		}
		

	}

}
