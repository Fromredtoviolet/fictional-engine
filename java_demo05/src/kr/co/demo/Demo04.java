package kr.co.demo;

import java.util.Random;

public class Demo04 {

	public static void main(String[] args) {
		/*
		 * Random 클래스
		 * 랜덤으로 난수를 출력할 수 있다.
		 * 단, 문자와 문자열은 아스키코드로 출력된다.
		 */
		Random rand = new Random();
		
		int num = rand.nextInt(5);	// 범위를 0~4까지 지정하는 구문(0,1,2,3,4)
		
		System.out.println(num);

	}

}
