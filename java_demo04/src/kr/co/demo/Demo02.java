package kr.co.demo;

import java.util.Scanner;

public class Demo02 {

	public static void main(String[] args) {
		/*
		 * 문자열 비교
		 */
		Scanner sc = new Scanner(System.in);
		
		String s1, s2;
		s1 = "Hello";
		
		System.out.print("Hello 라고 입력하세요.: ");
		s2 = sc.nextLine();
		
		/*
		if(s1 == s2) {
			System.out.println("입력한 문자열이 Hello 입니다.");
		} else {
			System.out.println("입력한 문자열이 Hello 가 아닙니다.");
		}
		 문자열끼리는 단순 비교가 안 된다! 참조값끼리의 비교가 되기 때문.
		 문자열은 변수 안에 값이 있는게 아니라 참조값이 있는 특수성 때문에,
		 단순 비교 연산자가 아닌 equals를 써줘야 한다.
		*/
		
		
		
		if(s1.equals(s2)) {
			System.out.println("입력한 문자열이 Hello 입니다.");
		} else {
			System.out.println("입력한 문자열이 Hello 가 아닙니다.");
		}

	}

}
