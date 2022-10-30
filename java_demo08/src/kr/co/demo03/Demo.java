package kr.co.demo03;

import java.util.StringTokenizer;

public class Demo {

	public static void main(String[] args) {
		/*
		 * StringTokenizer
		 * 		문자열을 특정 구분 문자를 기준으로 분리하는 클래스
		 * 		(대부분 스트링 클래스의 split을 쓰면 되니까 중요하진 않음)
		 */
		String str = "A,B,C,D,E";
		
		StringTokenizer sToken = new StringTokenizer(str, ",");
		
		while(sToken.hasMoreTokens()) {
			System.out.println(sToken.nextToken());
		}

	}

}
