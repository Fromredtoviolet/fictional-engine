package kr.co.exam01;

public class Figure {
	private double width;
	private double vertical;
	private double area;
	
	public Figure() {
		
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

	public void whatArea() {
		this.area = (this.width * this.vertical);
	}
	
}
