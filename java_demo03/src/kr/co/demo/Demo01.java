package kr.co.demo;

public class Demo01 {

	public static void main(String[] args) {
		// 연산자
		int x = 10;
		// x = x + 1;
//		x += 1; // 변수 x에 정수 1을 더하고 그 결과에 대해 할당해라. (복합 할당)
//		System.out.println(x);
				
//		int a = 20;
//		a -= 1; // 변수 y에 정수 1을 빼고 그 결과에 대해 할당해라.
//		System.out.println(a);
		
//		int b = 5;
//		b *= 2; // 변수 z에 정수 2를 곱하고 그 결과에 대해 할당해라.
//		System.out.println(b);
		
//		int c = 30;
//		c /= 5; // 변수 a에 정수 5를 나누고 그 몫에 대해 할당해라.
//		System.out.println(c);
		
//		c %= 4; // 변수 a에 정수 4를 나누고 그 나머지에 대해 할당해라.
//		System.out.println(c);
		
		for(int y = 0, z = 2; y <= 5; y++, z += 2) {
			System.out.println(y + "/" + z);
		}
		
		//x > 3 이 비교가 참이면 변수 s 에 10을 저장하고 거짓이면 0을 저장해라.
		x = x > 3 ? 10 : 0;
		System.out.println(x);
		
		
		
	}

}
