package kr.co.demo;

public class Exam01 {

	public static void main(String[] args) {
		// 1. 문자열 변수 name 에 자신의 이름을 저장
		
		// 2. 정수 변수 age 에 자신의 나이를 저장
		
		// 3. 실수 변수 tall 에 자신의 키를 저장
		
		// 4. 변수에 저장된 모든 값을 .println() 메서드를 사용하여 출력
		
		// 5. 변수에 저장된 값을 활용하여 다음 형식에 맞추어 출력
		//	  .print() / .printf() / .println() 중 사용하기 편한 메서드 하나를 선택하여 출력		
		// 형식: 저의 이름은 홍길동 입니다. 올해 30 세이며, 내년에는 31 세가 됩니다.
		
		// 6. 문자열 상수 MALE 과 FEMALE 을 생성하고 각각 "남성", "여성" 으로 초기화 하세요.
		
		// 7. 변수와 상수에 저장된 값을 활용하여 다음 형식에 맞추어 출력하세요.
		// 형식: 저의 키는 175.5 로 대한민국 남성 표준 키보다 조금 큽니다.
		// 형식: 저의 키는 175.5 로 대한민국 여성 표준 키보다 많이 큽니다.
		
		String name = "서예인";
		int age = 30;
		double tall = 159.5;
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(tall);
				
		System.out.println("저의 이름은 " + name + " 입니다. 올해 " + age + " 세이며, 내년에는 " + (age+1) + " 세가 됩니다.");
		System.out.printf("저의 이름은 %s 입니다. 올해 %d 세이며, 내년에는 %d 세가 됩니다.\n", name, age, (age+1));
		// 개행을 하고싶을때 굳이 .println 할 필요 없이 문장 끝에 \n을 넣으면 줄바꿈 완.
		
		final String FEMALE = "여성";
		final String MALE = "남성";
		
		System.out.println("저의 키는 " + tall + "cm 로 대한민국 " + FEMALE + " 표준 키에 가깝습니다.");
		System.out.printf("저의 키는 %.1fcm 로 대한민국 %s 표준 키에 가깝습니다.", tall, FEMALE);
		
		
		
	

	}

}
