package kr.co.exam;

import java.util.Random;

public class Exam05_1 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 0인 정수 배열을 생성 후 난수(Random)를 사용하여
		 * 0 ~ 100 까지의 임의값을 생성 후 배열에 추가한다.
		 * (총 6개의 정수값을 추가하도록 한다.)
		 * 동적배열 이용
		 */
		Random rand = new Random();
		
		int num = 0;
		for(num = 0; num < 101; num++) {
		num = rand.nextInt(101);
		}
		
		int arr1[] = new int[0];
		
		int tmp[] = new int[arr1.length + 6];
		
		for(int j = 0; j < arr1.length; j++) {
			tmp[j] = arr1[j];
		}
			
		tmp[tmp.length - 1] = num;
		tmp[tmp.length - 2] = num;
		tmp[tmp.length - 3] = num;
		tmp[tmp.length - 4] = num;
		tmp[tmp.length - 5] = num;
		tmp[tmp.length - 6] = num;
		
		arr1 = tmp;
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
			
	}

}
