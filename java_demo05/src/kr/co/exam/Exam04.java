package kr.co.exam;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/*
		 * Exam03.java 와 동일한 과정으로 배열을 생성할 때
		 * 중복된 값이 없도록 초기화 하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		int size = 0;
		
		while(!(size >= 2 && size <= 5)) {
			System.out.print("2 ~ 5 사이의 정수 입력 : ");
			size = sc.nextInt();
		}
		
		int arr1[] = new int[size];
		
		for(int i = 0; i < size;) {
			System.out.print("1 ~ 10 사이의 정수 입력 : ");
			int num = sc.nextInt();
			
			if(num >= 1 && num <= 10) {
				boolean isDup = false;
				for(int j = 1; j <= i; j++) {
					if(arr1[j] == num) {
						isDup = true;
						break;
					}
				}
				if(!isDup) {
						System.out.printf("%d 위치에 %d 값으로 초기화하였습니다.\n", i, num);
						arr1[i] = num;
						i++;
				}
			} else {
				System.out.println("값을 다시 확인해서 입력하세요.");
			}
		}
		for(int i = 0; i < size; i++) {
			System.out.printf("%d\t", arr1[i]);
		}

	}

}
