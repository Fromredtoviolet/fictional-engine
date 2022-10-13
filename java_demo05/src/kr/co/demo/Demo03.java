package kr.co.demo;

import java.util.Scanner;

public class Demo03 {

	public static void main(String[] args) {
		/*
		 * 동적 배열
		 * 원래 배열의 크기는 고정이다. 
		 * 동적 배열은 기존 배열의 크기를 바꾸는게 아니고, 새로운 배열을 만들어 사용할 뿐이다.
		 * 단지 이를 쉽게 표현하여 배열의 크기가 줄었다/늘었다라고 표현하는 것이다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int arr1[] = new int[3];
		arr1[0] = 1; arr1[1] = 2; arr1[2] = 3; 
		
		for(int i = 0; i < 3; i++) {
			System.out.print("정수값 입력 : ");
			int num = sc.nextInt();
			
			int tmp[] = new int[arr1.length + 1]; // 새로운 배열 생성이므로 깊은 복사 해와야함
			
			for(int j = 0; j < arr1.length; j++) {
				tmp[j] = arr1[j];
			}
			
			tmp[tmp.length - 1] = num;
			
			arr1 = tmp;					// 얕은 복사
			
			
			System.out.println("%d 값을 배열 arr1 에 추가하였습니다.");
		}
		
		System.out.println("새로운 배열의 참조 주소 -> " + arr1);
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
		
		
	}

}
