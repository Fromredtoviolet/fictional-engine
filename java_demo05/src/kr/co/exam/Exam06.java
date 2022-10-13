package kr.co.exam;

import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받아서 다음의 기능을 수행하는 코드를 작성
		 * 		1. 입력한 횟수만큼 정수값을 입력 받아서 배열에 저장한다.
		 * 		2. 배열에 저장된 모든 정수의 합과 평균을 구하여 출력
		 * 		3. -1 입력이 들어오면 더이상 사용자 입력을 받지 않는 것으로 한다.
		 * 
		 * 예제
		 * 		1 번째 정수값 입력 : 7
		 * 		2 번째 정수값 입력 : 12
		 * 		3 번째 정수값 입력 : 24
		 * 		4 번째 정수값 입력 : -1
		 * 
		 * 		총 합 : 43
		 * 		평 균 : 14.3
		 * 		
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int arr1[] = new int[0]; 
		int count = 0;
		int sum = 0;
		double avg;
		
		int num = 0;
		while(true) {
			System.out.printf("%d 번째 정수값 입력: ", ++count);
			num = sc.nextInt();
			
			if(num == -1) {
				break;
			}
			
			int tmp[] = new int[arr1.length + 1];
			
			for(int i = 0; i < arr1.length; i++) {
				tmp[i] = arr1[i];
			}
			
			arr1 = tmp;
			
			arr1[arr1.length - 1] = num;
			
			sum += num;  	// 누적합
		}
		
		avg = (double)sum / arr1.length;
		System.out.printf("총 합 : %d\n", sum);
		System.out.printf("평 균 : %.2f\n", avg);
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
		System.out.println();
		
		

	}

}
