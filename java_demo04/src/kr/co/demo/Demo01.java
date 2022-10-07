package kr.co.demo;

public class Demo01 {

	public static void main(String[] args) {
		/*
		 *  if 조건문
		 *  	프로그램 수행 흐름을 바꾸기 위한 역할을 수행하는 제어문 중 하나.
		 *  	조건에 따라 다른 코드가 실행되도록 한다.
		 *  
		 *  if(조건식) {
		 *  	...
		 *  }
		 *  
		 *  if(조건식) { 
		 *  	...     (true)
		 *  } else {            <= if else 구문
		 *  	...     (false)
		 *  }
		 *  
		 *  if(조건식A) {
		 *  	...
		 *  } else if(조건식B) {
		 *  	...					<= if else if 구문
		 *  } else if(조건식C) {
		 *  	...
		 *  }
		 *  
		 *  if(조건식A) {
		 *  	if(조건식B) {
		 *  		...				<= 중첩 if
		 *  	}
		 *  } 
		 */
		
		/*
		int x1 = 4;
		
		if(x1 % 2 == 1) {
			System.out.println("변수 x1에 저장된 정수값은 홀수입니다.");
		}
		System.out.println("프로그램이 종료됩니다.");	
		*/
		
		/*
		int x2 = 4;
		
		if(x2 % 2 ==1) {
			System.out.println("변수 x2에 저장된 정수값은 홀수 입니다.");
		} else {
			System.out.println("변수 x2에 저장된 정수값은 짝수 입니다.");
		}
		System.out.println("프로그램이 종료 됩니다.");
		}
	
	*/
		/*
		int x3 = 15;
		
		if(x3 < 10) {
			System.out.println("변수 x3에 저장된 정수값은 10보다 작습니다.");
		} else if(x3 < 20) {
			System.out.println("변수 x3에 저장된 정수값은 10 이상이고 20보다 작습니다.");
		} else if(x3 < 30) {
			System.out.println("변수 x3에 저장된 정수값은 20 이상이고 30보다 작습니다.");
		} else if(x3 < 40) {
			System.out.println("변수 x3에 저장된 정수값은 30 이상이고 40보다 작습니다.");		
		} else {
			System.out.println("변수 x3에 저장된 정수값은 40 이상입니다.");
		}
		
		System.out.println("프로그램이 종료됩니다.");
	*/
		
		int x4 = 11;
		
		if(x4 < 10) {
			if(x4 % 2 == 0) {
				System.out.println("변수 x4에 저장된 정수값은 10보다 작은 짝수입니다.");
			} else {
				System.out.println("변수 x4에 저장된 정수값은 10보다 작은 홀수입니다.");
			}
		} else {
			System.out.println("변수 x4에 저장된 정수값은 10 큽니다.");
		}
		
		System.out.println("프로그램이 종료됩니다.");
			
		

	}
}