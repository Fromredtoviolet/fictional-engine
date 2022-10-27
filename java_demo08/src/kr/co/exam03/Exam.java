package kr.co.exam03;

import java.util.Scanner;

public class Exam {
	
	public static boolean isNumber(String number) {
		boolean result = true;
		
		for(int i = 0; i < number.length(); i++) {
			if(!(number.charAt(i) >= '0' && number.charAt(i) <= '9')) {
				return false;
			}
		}
		
		return result;
	}
	
	public static boolean isNumeric(String number) {
		return number.matches("[0-9]+"); // 스트링 메서드. 정규표현식을 이용해서 내가 원하는 문자열인지 참과 거짓을 가림
	} // '+'가 붙은 이유는 1글자 이상인지 체크하려고. 안 붙으면 그냥 1글자만 체크함.

	public static void main(String[] args) {
		/*
		 * 사용자 입력으로 정수형 문자열을 입력받아 총합 구하기
		 */
		Scanner sc = new Scanner(System.in);

		System.out.print("공백을 구분자로 하는 정수를 나열하시오. : ");
		String input = sc.nextLine();
		String[] strArr = input.split(" ");
		int[] iArr = new int[strArr.length];
		
		int sum = 0;
		for(int i = 0; i < strArr.length; i++) {
			// 정수로 변환할 수 없는 문자열인 경우 0 으로 저장하게 한다.
			boolean numberValid = isNumber(strArr[i]);
			if(numberValid) {
				iArr[i] = Integer.parseInt(strArr[i]);
				sum += iArr[i];
			}
		}
		System.out.println("총 합 : " + sum);

	}
}
