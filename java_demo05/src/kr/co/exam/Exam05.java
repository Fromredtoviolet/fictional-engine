package kr.co.exam;

import java.util.Random;

public class Exam05 {

	public static void main(String[] args) {
		Random rand = new Random();
		
		/*
		 * 배열의 크기가 0인 정수 배열을 생성 후 난수(Random)를 사용하여
		 * 0 ~ 100 까지의 임의값을 생성 후 배열에 추가한다.
		 * (총 6개의 정수값을 추가하도록 한다.)
		 * 동적배열 이용
		 */
		int arr1[] = new int[0];
		
		for(int i = 0; i < 6; i++) {
			int num = rand.nextInt(101); // for 구문 밖으로 빠지면 같은 값만 나옴.
			
			int size = arr1.length + 1;
			int tmp[] = new int[size];
			
			for(int j = 0; j < arr1.length; j++) {
				tmp[j] = arr1[j];
			}
			
			arr1 = tmp;
			
			arr1[arr1.length - 1] = num;
		}
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
		System.out.println();
			
					
		
		/*
		 * 배열의 크기가 0인 정수 배열을 생성 후 난수(Random)를 사용하여
		 * 0 ~ 100 까지의 임의값을 생성 후 배열에 추가한다.
		 * (단, 홀수에 해당하는 값만 6개 추가하도록 한다.)
		 * 동적배열 이용
		 */
		int arr2[] = new int[0];
		
		for(int i = 0; i < 6;) {
			int num = rand.nextInt(101);
			
			if(num % 2 == 0) {
				continue;		// num이 홀수라면 빠져나가서 다음 식으로, 짝수라면 다시 식을 재생
			}
			
			int size = arr2.length + 1;
			int tmp[] = new int[size];
			
			for(int j = 0; j < arr2.length; j++) {
				tmp[j] = arr2[j];
			}
			
			arr2 = tmp;
			
			arr2[arr2.length - 1] = num;
			
			i++; 		// 홀수여야만 증가해야 하므로 증감식을 여기에 쓴다.
		}
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.printf("%d\t", arr2[i]);
		}
		System.out.println();
		
		
		
	}

}
