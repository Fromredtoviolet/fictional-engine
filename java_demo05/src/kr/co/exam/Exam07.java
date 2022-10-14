package kr.co.exam;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exam07 {

	public static void main(String[] args) {
		/*
		 * 3 행, n 열에 해당하는 2차 배열을 만들어보세요.
		 * 		1. n은 사용자 입력을 통해 3 ~ 9 사이의 정수를 받아 사용하세요.
		 * 		2. 배열에 초기화하는 데이터는 랜덤을 사용하여 1 ~ 99 사이의 값을
		 * 			저장하도록 하세요.
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int size = 0;
		while(true) {
			System.out.print("3부터 9까지의 정수 중 하나를 입력하세요. : ");
			size = sc.nextInt();
			if(size >= 3 && size <= 9) {
			break;
			}
		}

		int arr[][] = new int[3][];
		
		
		// 동적 배열을 적용하여 2차 배열에 값 저장.
		// 1. 일반적인 1차 배열 생성.
		// 2. 1차 배열을 동적 배열로 활용하여 랜덤값 추가.
		// 3. 1차 배열의 참조 주소를 2차 배열의 행에 등록 -> arr[0] = 참조주소;
		
		for(int i = 0; i < arr.length; i++) {
			int tmp[] = new int[0]; // 이 임시 1차배열은 반복문 안에 있어야 함
			for(int j = 0; j < size; j++) {
				int num = rand.nextInt(99) + 1;		// 0 ~ 98 + 1
				tmp = Arrays.copyOf(tmp, tmp.length + 1);
				tmp[tmp.length - 1] = num;
			}
			arr[i] = tmp;
		}	
		 
		 for(int i = 0; i < arr.length; i++) {
		 System.out.println(Arrays.toString(arr[i]));
		 }
		 
		 
	}
}


	
