package kr.co.demo05;

public class Circle {
			// 공유하는 값이므로 static 사용.
	private static final double PI = 3.14; 
					// 내부에서도 변경되면 안되므로 상수 사용.
	private double radius;
	private double area;
	
	public Circle(double radius) {
		this.radius = radius;
		this.area = radius * radius * Circle.PI;
	}								//PI는 이제 인스턴스가 아니므로, 
									//this가 아닌 클래스명 Circle을 사용

	public double getRadius() {
		return this.radius;
	}
	
	public double getArea() {
		return this.area;
	}
	
	public double getPI() {
		return this.PI;
	}
}
