package kr.co.demo01;

public class Student extends Person {
						// ↑부모클래스
	private int year;
	private int classRoom;
	
	public Student() {
		super("학생");
	}
	
	public Student(String name) { // 매개변수 없는 기본 생성자를 쓰고 싶다면
		super(name); // 부모를 호출하는 super 사용
	} 
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getClassRoom() {
		return classRoom;
	}
	
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	/*
	 * 메서드 오버라이드
	 * 		기존 부모 클래스가 가지고 있는 메서드를 자식에서 재정의하여 사용하는 것.
	 * 		기존 부모에 정의한 메서드명, 매개변수 타입/수량, 반환타입이 자식도 동일해야 한다.
	 * 		메서드 오버라이드 대상에는 반드시 @Override 어노테이션을 메서드명 위에 작성한다.
	 * 		접근제한자는 부모의 접근제한자보다 넓거나 같은 범위로 작성해야 한다.
	 * 
	 * 		예외처리: 부모보다 같거나 좁은 범위 또는 적은 수의 예외처리여야 한다.
	 * 		final 키워드가 사용된 메서드에 대해서는 오버라이드를 할 수 없다.
	 */
	@Override 
	public void addAge() { // 부모 클래스의 addAge라는 메서드를 자식이 재정의함.
		super.addAge(); // 부모가 가진 addAge를 활용할 수 있으므로 이걸 써도 됨.
		// this.setAge(this.getAge() + 1); 아니면 이렇게 풀어서 써도 되고.
		this.year++;
	}
}
