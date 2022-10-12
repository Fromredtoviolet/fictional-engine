package kr.co.exam;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if 문을 활용하여 사용자로부터 키(m)와
		 * 체중(kg) 값을 입력받아 BMI를 구하여 결과값을 출력할 때
		 * 25 이상의 결과인 경우 "비만입니다." 라는 메시지가 출력되도록 하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		double tall, weight, bmi;
		
		System.out.println("키(m)를 입력하세요.: ");
		tall = sc.nextDouble();
		
		System.out.println("체중(kg)을 입력하세요.: ");
		weight = sc.nextDouble();
		
		bmi = weight / (tall * tall);
		
		
		if(bmi >= 25) {
			System.out.println("비만입니다.");
		} else {
			System.out.println("비만이 아닙니다.");
		}
		
		
		// 강사님 코드 1
//		String message = "비만입니다.";  
		
//		if(bmi < 25) {
//			message = "비만이 아닙니다";
//		}
//		System.out.println(message);
		
		// 강사님 코드 2
//		String message = bmi < 25 ? "비만이 아닙니다." : "비만입니다.";
//		System.out.println(message);

	}

}
