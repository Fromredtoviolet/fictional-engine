package kr.co.Exam02;

public class Subject {
	private String name;
	private int score;
	private String grade;
	
	public Subject(String name) {
		this.name = name;
	} //this는 자기자신에 대한 메서드나 변수를 사용할 때 붙이는 것.
	
	public void setScore(int score, String grade) {
		this.score = score;
		this.grade = grade;
	}
	
	
	
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return this.score;
	}
	public String getGrade() {
		return this.grade;
	}
}
