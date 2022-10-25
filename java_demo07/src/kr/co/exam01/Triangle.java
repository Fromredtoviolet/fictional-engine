package kr.co.exam01;

public class Triangle extends Figure {
	// 삼각형의 넓이 = 0.5 * 밑변 * 높이
	private double width;
	private double vertical;
	private double area;
	
	public Triangle(double width, double vertical) {
		super(width, vertical);
	}

	@Override
	public void whatArea() {
		this.area = this.width * this.vertical / 2;
	}
	
	public double getArea() {
		this.whatArea();
		return this.area;
	}

	
	
		
}
