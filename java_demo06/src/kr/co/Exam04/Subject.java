package kr.co.Exam04;

public class Subject {
	private String subName; // 과목명
	private int score;		// 점수
	private char subGrade;	// 과목등급
	
	public Subject(String subName) {
		this.subName = subName;
	}


	public void setScore(int score) {
		if(0 <= score && score <= 100) {
			this.score = score;
		} else {
			this.score = 0;
		}
		this.setSubGrade();
	}
	
	public void setSubGrade() {
		switch(this.score / 10) {
		case 10:
		case 9:
			this.subGrade = 'A';
			break;
		case 8:
			this.subGrade = 'B';
			break;
		case 7:
			this.subGrade = 'C';
			break;
		case 6:
			this.subGrade = 'D';
			break;
		default:
			this.subGrade = 'F';
		}
	}
	
	public String getName() {
		return this.subName;
	}
	public int getScore() {
		return this.score;
	}
	public char getGrade() {
		return this.subGrade;
	}
}
