package kr.co.Exam04;

public class Student {
	private Subject subject[];	// 과목클래스 배열
	private String stuName;		// 학생이름
	private String stuGrade;	// 학년
	
	public Student() {
		this.subject = new Subject[0];
		this.stuName = stuName;
		this.stuGrade = stuGrade;
		
	}
	
	public void addSub(String subName) {
		
	}
	
	public void updateScore() {
		
	}
	
	public void deleteSub() {
		
	}
	
	public String getAll() {
		String str = "";
		for(int i = 0; i < this.subject.length; i++) {
			Subject s = this.subject[i];
		}
		return str;
	}

}
