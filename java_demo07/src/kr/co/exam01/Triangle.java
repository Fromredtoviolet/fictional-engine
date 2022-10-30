package kr.co.exam01;

public class Triangle extends Figure {
	private double width;
	private double vertical;
	
	public Triangle(double width, double vertical) {
		super(width, vertical);
	}
	@Override
	public double getArea() {
		return super.getArea() / 2;
	}

//	내가 써서 오류난 코드...
//	public double getArea() {
//		this.area = (this.width * this.vertical) / 2;
//		return this.area;
//	}

	
	
		
}
