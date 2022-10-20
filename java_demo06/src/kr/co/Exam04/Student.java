package kr.co.Exam04;

import java.util.Arrays;

public class Student {
	private Subject subjects[];	// 과목클래스 배열
	private String name;		// 학생이름
	private int year;			// 학년
	
	public Student(String name) {
		this.subjects = new Subject[0];
		this.name = name;
	}
	
	
	
	public void addSubject(String subName, double score) {
		this.subject = Arrays.copyOf(this.subject, this.subject.length + 1);
		this.subject[this.subject.length - 1] = new Subject(subName);
	}
	
	public void updateScore() {
		
	}
	
	public void deleteSubject() {
		
	}
	
	public String getAll() {
		String str = "";
		for(int i = 0; i < this.subject.length; i++) {
			Subject s = this.subject[i];
		}
		return str;
	}

	
	public Subject getSubject(String subject.name) {
		Subject result = null;
		int idx = this.findIndex()
				
		if(idx >= 0) {
			result = this.subjects[idx]
		}
		return result;
		
	}
	

}
