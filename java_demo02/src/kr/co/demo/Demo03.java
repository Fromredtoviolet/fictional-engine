package kr.co.demo;

public class Demo03 {

	public static void main(String[] args) {
		// 형변환 : 변수에 저장된 특정 자료형의 데이터를 다른 자료형의 변수에 저장하기
		//		   위해 자료형의 종류를 변환시켜주는 작업을 형변환이라고 하며, 캐스팅
		//		   (Casting)이라고 한다.
		
		// 형변환은 일반적으로 다음의 경우에 필요하다.
		// 정수 -> 정수 / 정수 -> 실수 / 실수 -> 정수 / 실수 -> 실수
		
		// 자료형의 크기가 작은 자료형에서 큰 자료형으로 변환을 할 때 -> 자동 형변환		
		// 자료형의 크기가 큰 자료형에서 작은 자료형으로 변환을 할 때 -> 강제 형변환
		byte bt1;
		short st1 = 500;
		
		bt1 = (byte)st1; // 앞에 (byte)를 붙여줘야 캐스팅!
		// (byte)를 안 붙여서 오류메세지가 뜰 때, 이클립스가 자동으로 캐스팅을 추천해줌
		
		int it1 = (int)(10 + 10.5); // 큰 애를 작은 애로 강제 형변환 시켜줘야 하는 예시
		double it2 = 10 + 10.5; // 작은 애를 큰 애로 자동 형변환 하는 예시
		System.out.println(it1); // 10+10.5에서 소수점 밑을 희생시키므로 20
		
		String str1 = "문자열";
		str1 = str1 + 10; // 여기서의 +는 더하기 연산이 아닌 '결합'의 의미
		System.out.println(str1);
		
		String str2 = "문자열";
		str2 = 20 + str2;
		System.out.println(str2);
		
		
		

	}

}
