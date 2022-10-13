package kr.co.exam;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력으로 2 ~ 5 사이의 정수 값을 입력 받아
		 * 입력 받은 정수값과 동일한 크기의 배열을 생성하고,
		 * 배열의 값을 초기화 하기 위해 다시 사용자 입력을 사용하여
		 * 1 ~ 10 사이의 값만을 입력 받아 초기화 하세요.
		 */
		Scanner sc = new Scanner(System.in);
		int size = 0;
		// size라는 정수의 변수 선언
		
		while(!(size >= 2 && size <= 5)) {
			System.out.print("2 ~ 5 사이의 정수 입력 : ");
			size = sc.nextInt();
		}
		// while 반복문. size라는 정수변수의 범위가 2~5가 아닐때, 사용자 입력을 받는다.
		// 이 경우 0으로 초기화되어 있으므로 2~5 범위를 충족 못하기 때문에 사용자 입력을 받게 된다.
		
		int arr1[] = new int[size];
		// arr1 정수배열 선언. 크기는 size라는 변수와 같다.
		// 즉, arr1의 배열 크기는 위에서 사용자가 입력한 size값과 같다.
		
		for(int i = 0; i < size;) {		// for 반복문. 배열의 칸마다 값 넣기 위해.
			System.out.print("1 ~ 10 사이의 정수 입력 : ");
			int num = sc.nextInt();
			
			if(num >= 1 && num <= 10) {
				arr1[i] = num;
				System.out.printf("%d 위치에 %d 값으로 초기화하였습니다.", i, num);
				i++;
			} else {
				System.out.println("값을 다시 확인해서 입력하세요.");
			}  
		}
		for(int i = 0; i < size; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
	}

}
