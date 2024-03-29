package kr.co.demo;

import java.util.Arrays;

public class Demo06 {

	public static void main(String[] args) {
		/*
		 * 2차 배열
		 * 		배열 안에 배열이 중첩되어 사용하는 것
		 * 		중첩 횟수에 따라 N차 배열이라고 한다.
		 * 
		 * 작성 방법
		 * 		int arr[][];
		 * 		int[][] arr;
		 * 
		 * 		int arr[][] = new int[행크기][열크기];
		 * 		int arr[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		 */

		 int arr1[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		 
		 System.out.println(arr1[2][1]);
		 
		 // 전체 탐색
		 for(int i = 0; i < arr1.length; i++) {
			 for(int j = 0; j < arr1.length; j++) {
				 System.out.printf("arr1[%d][%d] -> %d\n", i, j, arr1[i][j]);
				 
				 
			 }
		 }
		 
		 /*
		  * 가변 길이 배열
		  * 	2차 배열의 행에 해당하는 배열의 길이가 가변적으로 만들어서 사용할 수 있는 형태
		  * 							
		  * { 	   					{
		  *	  {1, 2, 3}, <- 행			{1, 2},
		  *	  {4, 5, 6}, <- 행			{3, 4, 5, 6, 7},	<= 가변 길이 배열
		  *	  {7, 8, 9}  <- 행			{8, 9, 10}
		  * }						}
		  * 
		  * 가변 길이 배열은 행의 배열의 길이가 다르기 때문에 전체 탐색을 진행할 때
		  * 반드시 행마다 배열의 길이를 구하여 반복하도록 해야 한다.
		  */
		 
		 int arr2[][] = {
				 {1, 2},
				 {3, 4, 5, 6, 7},
				 {8, 9, 10}
		 		};
		 for(int i = 0; i < arr2.length; i++) {
			 for(int j = 0; j < arr2[i].length; j++) {
				 System.out.print(arr2[i][j] + "\t");
			 }
			 System.out.println();
		 }
	}

}
