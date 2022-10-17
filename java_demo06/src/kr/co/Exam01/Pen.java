package kr.co.Exam01;

public class Pen {
	private String color;
	private double ballSize;
	private String inkType;
	private boolean simOut = false;
	
	public Pen(String color, double ballSize, String inkType) {
		this.color = color;
		this.ballSize = ballSize;
		this.inkType = inkType;
	}
	
	public void simChange(String color, String inkType) {
		this.color = color;
		this.inkType = inkType;
	}
	
	public void simOut() {
		System.out.println("펜 심이 나왔습니다. 글을 쓸 수 있습니다.");
		this.simOut = true;
	}
	public void simIn() {
		System.out.println("펜 심이 들어갔습니다. 글을 쓸 수 없습니다.");
		this.simOut = false;
	}
	
	public void write(String message) {
		if(simOut) {
		System.out.printf("%s 색상으로 다음의 글을 작성합니다.\n", this.color);
		System.out.println("\t" + message);
		} else {
			System.out.println("글을 작성하려면 펜 심이 나오게 하세요.");
			
		}
	}

	public String getColor() {
		return this.color;
	}
	public double getBallSize() {
		return this.ballSize;
	}
	public String getInkType() {
		return this.inkType;
	}

}
