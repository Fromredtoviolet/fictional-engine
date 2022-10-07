package kr.co.Exam;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 다음의 문제를 풀어보세요.
		 * 
		 * 카카오의 더치페이 기능을 모방하여 다음의 출력 결과가 나오도록 하세요.
		 * 
		 * 출력 형식
		 * 		총 비용 50000 원을 5 명이 더치페이하여 10000 원씩 
		 * 		다음의 계좌로 입금해 주세요.
		 * 		입금 계좌 번호 : 1234-56-789-123456789
		 * 		나머지 금액 0 원은 제가 부담합니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계좌번호를 입력: ");
		String paid = sc.nextLine();	
		
		System.out.print("총 비용을 입력: ");
		int pay = sc.nextInt(); 
		
		System.out.print("인원수를 입력: ");
		int party = sc.nextInt(); 
		
	
		System.out.println("총 비용 " + pay + " 원을 " + party + " 명이 더치페이하여 " + (pay/party) + " 원씩 다음의 계좌로 입금해주세요.");
		System.out.println("입금 계좌 번호 : " + paid);
		System.out.println("나머지 금액 " + (pay%party) + " 원은 제가 부담합니다.");
		
		// "총 비용 %d 원을 어쩌구저쩌구"하는 문장에서 %,d로 표기하면 3,000원처럼 표기됨

	}

}
