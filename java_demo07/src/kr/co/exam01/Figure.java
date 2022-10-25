package kr.co.exam01;

public class Figure {
	private double width;
	private double vertical;
	private double area;
	

	public Figure(double width, double vertical) {
		this.width = width;
		this.vertical = vertical;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getVertical() {
		return vertical;
	}

	public void setVertical(double vertical) {
		this.vertical = vertical;
	}

	public double getArea() {
		this.whatArea();
		return this.area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public void whatArea() {
		this.area = (this.width * this.vertical);
		this.setArea(area);
	}
	
	
}
