package kr.co.exam01;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 도형 클래스를 상속하는 삼각형, 사각형 클래스를 작성하시오.
		 * 
		 * 삼각형, 사각형 클래스는 다음의 멤버 변수와 메서드가 필요하다.
		 * 		- 삼각형
		 * 			멤버 변수 : 가로길이, 세로길이
		 * 			멤버 메서드 : 넓이 구하기
		 * 		- 사각형
		 * 			멤버 변수 : 가로길이, 세로길이
		 * 			멤버 메서드 : 넓이 구하기
		 */
		
		Triangle t = new Triangle(3, 3);
		Rectangle r = new Rectangle(3, 3);
		
		System.out.println(t.getArea());
		System.out.println(r.getArea());
		
	}

}
