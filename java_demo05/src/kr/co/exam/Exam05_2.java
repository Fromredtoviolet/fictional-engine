package kr.co.exam;

import java.util.Random;

public class Exam05_2 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 0인 정수 배열을 생성 후 난수(Random)를 사용하여
		 * 0 ~ 100 까지의 임의값을 생성 후 배열에 추가한다.
		 * (단, 홀수에 해당하는 값만 6개 추가하도록 한다.)
		 * 동적배열 이용
		 */
		int arr2[] = new int[0];
		
		Random rand = new Random();
		int num1 = rand.nextInt(101);
		int num2 = rand.nextInt(101);
		int num3 = rand.nextInt(101);
		int num4 = rand.nextInt(101);
		int num5 = rand.nextInt(101);
		int num6 = rand.nextInt(101);
		
		
		int tmp[] = new int[arr2.length + 6];
		
		for(int j = 0; j < arr2.length; j++) {
			tmp[j] = arr2[j];
		}
			
		tmp[tmp.length - 1] = num1;
		tmp[tmp.length - 2] = num2;
		tmp[tmp.length - 3] = num3;
		tmp[tmp.length - 4] = num4;
		tmp[tmp.length - 5] = num5;
		tmp[tmp.length - 6] = num6;
		
		arr2 = tmp;
		
		for(int i = 0; i < arr2.length; i++) {
			if(num1 % 2 == 1) {
			System.out.printf("%d\t", arr2[i]);
		}
		}
			
		
	}

}
