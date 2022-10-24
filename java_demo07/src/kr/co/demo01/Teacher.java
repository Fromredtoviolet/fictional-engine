package kr.co.demo01;

public class Teacher extends Person {
	private String subject;
	private String role; // 과목인지 담임인지 교장인지 교감인지~
	
	public Teacher() {
		super("선생님");
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
