package kr.co.exam;

import java.util.Scanner;

public class Exam08 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 사용자가 입력한 2 개의 정수값 n, m을 n ~ m까지의
		 * 반복 또는 m ~ n까지의 반복을 수행하는 코드를 작성하시오.
		 */
		Scanner sc = new Scanner(System.in);
		
		int n, m, min, max;
		
		System.out.println("첫번째 정수값 입력 : ");
		n = sc.nextInt();
		
		System.out.println("두번째 정수값 입력 : ");
		m = sc.nextInt();
		
		if(n < m) {
			min = n;
			max = m;
		} else {
			min = m;
			max = n;
		}
		for(; min <= max; min++) {
				System.out.printf("%d\n", min);
			}
		
		
		// 또는 더 짧게 코드 짜려면 이렇게도 가능함
		
		// min = n < m ? n : m;
		// max = n < m ? m : n;
		

	}

}
