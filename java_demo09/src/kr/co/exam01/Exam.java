package kr.co.exam01;

import kr.co.exam01.school.Evaluation;
import kr.co.exam01.school.Subject;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 과목에 대한 점수 및 등급을 계산하고 사용할 수 있도록 도와주는
		 * 클래스를 만든다.
		 * 		- 점수는 0 ~ 100 사이의 정수 및 실수만 입력할 수 있다.
		 * 		  해당 범위를 벗어나는 경우 NumberRangeOverException 이
		 * 		  발생할 수 있도록 사용자 정의 예외를 만드세요.
		 * 
		 * 		- 점수에 음수 값을 입력하는 경우 NegativeNumberException 이
		 * 		  발생할 수 있도록 사용자 정의 예외를 만드세요.
		 * 
		 * 		- 과목 클래스는 kr.co.exam01.school 패키지 안에 Subject 로 만드세요.
		 * 
		 * 		- 새로 추가하는 사용자 정의 예외는 kr.co.exam01.school.exception
		 * 		  패키지 안에 추가하세요.
		 * 
		 * 		- 생성한 과목 인스턴스를 System.out.println() 으로 출력에 사용할 때
		 * 		  "과목명(등급: 점수)" 형식으로 출력될 수 있게 toString() 을 오버라이드하세요.
		 * 
		 * 		- 두 개의 과목 객체가 제공될 때 점수가 가장 높은 과목 객체를 반환하는 메서드인
		 * 		  greatThen() 메서드를 추가하세요.
		 * 
		 * 		- 학교에서 수행평가용으로 Subject 클래스와 비슷한 객체를 만들어 달라는 요청이 있다고
		 *        가정한다. 이 때 수행평가는 1 ~ 10 사이의 점수로만 평가 점수를 매기며 6점 이상을
		 *        받아야 Pass 등급을 받을 수 있다. 5점 이하 부터는 Fail 등급이 된다.
		 *        (수행평가용 클래스를 생성할 때 기존의 Subject 클래스를 상속하여 만들어 보도록 한다.
		 *        클래스명은 Evaluation 으로 한다.)
		 */
		
		Subject a = new Subject();
		a.setScore(90);

		Subject b = new Subject();
		b.setScore(70);
		
		Subject grate = a.grateThen(b);
		System.out.println(grate);
		
		Evaluation ev1 = new Evaluation();
		ev1.setScore(5);
		System.out.println(ev1);

	}

}
