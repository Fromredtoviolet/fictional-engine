package kr.co.Exam;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 다음의 문제를 풀어보세요.
		 * 
		 * 현재 보유하고 있는 주식의 평단가 80000 원, 보유 주식 수 10주,
		 * 현 주식 가격이 65000 원 일 때 10주를 더 구매했을 경우의
		 * 총 구매액, 총 보유 주식수, 평단가, 수익률을 구하여 출력하세요.
		 * (수익률은 실수로 출력)
		 * 
		 * 사용자 입력으로 현재 보유 주식의 평단가, 보유 주식 수, 현 주식 가격,
		 * 추가 구매 주식 수를 받아서 풀어보세요.
		 * 
		 */
	Scanner sc = new Scanner(System.in);
	
	System.out.print("현재 보유 주식의 평단가: ");
	int a = sc.nextInt(); sc.nextLine();
	
	System.out.print("보유 주식 수: ");
	int b = sc.nextInt(); sc.nextLine();

	System.out.print("현 주식 가격: ");
	int c = sc.nextInt(); sc.nextLine();

	System.out.print("추가 구매 주식 수: ");
	int d = sc.nextInt(); sc.nextLine();
		
	System.out.println("총 구매액은 " + ((a*b)+(c*d)) + "원 입니다.");
	System.out.println("총 보유 주식수는 " + (b+d) + "주 입니다.");
	System.out.println("평단가는 " + ((a*b)+(c*d))/(b+d) + "원 입니다.");
	
	
	// holdStockPrice : 현재 보유 주식 단가
	// holdStockCount : 현재 보유 주식 수
	int holdStockPrice, holdStockCount;
	
	// presentStockPrice : 현 주식 가격
	// presentStockCount : 구입 예정 주식 수
	int presentStockPrice, presentStockCount;
	
	// totalStockPrice : 총 구매액
	// totalStockCount : 총 주식 수
	int totalStockPrice, totalStockCount;
	
	//평단가
	int averageStockPrice;
	
	// 예정 수익률
	double rateOfReturn;
	
	System.out.print("보유 주식 평단가: ");
	holdStockPrice = sc.nextInt();
	
	System.out.print("보유 주식 수: ");
	holdStockCount = sc.nextInt();
	
	System.out.print("현재 주식 가격: ");
	presentStockPrice = sc.nextInt();

	System.out.print("구입 예정 주식 수: ");
	presentStockCount = sc.nextInt();
	
	// 총 구매액 계산
	totalStockPrice = holdStockPrice * holdStockCount;
	totalStockPrice += presentStockPrice * presentStockCount;
	
	// 총 보유 주식 수 계산
	totalStockCount = holdStockCount + presentStockCount;
	
	// 현 주식 가격으로 구매했을 경우 예상되는 평단가 계산
	averageStockPrice = totalStockPrice / totalStockCount;
	
	// 예상 수익률 계산
	rateOfReturn = ((double)presentStockPrice / averageStockPrice - 1) * 100;
	
	String kind = rateOfReturn < 0 ? "감소" : "증가";
	
	String message = "총 구매액 : %,d\n"
			+ "총 보유 주식수 : %,d\n"
			+ "평단가: %,d\n"
			+ "수익률 : %.2f%%\n"
			+ "현재 자산이 %s하였습니다.";
	
	System.out.printf(message, totalStockPrice, totalStockCount, averageStockPrice, rateOfReturn, kind);
	

	}

}
