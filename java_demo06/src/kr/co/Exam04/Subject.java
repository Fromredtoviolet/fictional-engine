package kr.co.Exam04;

public class Subject {
	private String name; // 과목명
	private double score;		// 점수
	private char grade;	// 과목등급
	
	public Subject(String name) {
		this.name = name;
		this.grade = 'F';
	}
	// ↑ 메서드 오버로딩 ↓
	public Subject(String name, double score) {
		this.name = name;
		this.score = score;
		this.setGrade();
	}
	
	public String getName() {
		return this.name;
	}

	public void setScore(double score) {
		this.score = score;
		this.setGrade();
	}
	
	public double getScore() {
		return this.score;
	}
	
	public void setGrade() {
		switch((int)this.score / 10) {
		case 10:
		case 9:
			this.grade = 'A';
			break;
		case 8:
			this.grade = 'B';
			break;
		case 7:
			this.grade = 'C';
			break;
		case 6:
			this.grade = 'D';
			break;
		default:
			this.grade = 'F';
		}
	}
	
	public char getGrade() {
		return this.grade;
	}
}
