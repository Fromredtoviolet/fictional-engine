package kr.co.exam01;

public class Figure {
	private double width;
	private double vertical;
	public double area;
	

	public Figure(double width, double vertical) {
		this.width = width;
		this.vertical = vertical;
	}

	public double getArea() {
		this.area = this.width * this.vertical;
		return this.area;
	}
	
}
