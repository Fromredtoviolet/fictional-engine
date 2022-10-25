package kr.co.exam02;

public class Member extends Person {
	public void write() {
		System.out.println(getName() + "이(가) 글을 작성합니다.");
	}
	
	public void view() {
		System.out.println(getName() + "이(가) 작성한 글을 봅니다.");
	}
	
	public void update() {
		System.out.println(getName() + "이(가) 글을 수정합니다.");
	}

	@Override
	public String toString() {
		return "Member [getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}
}
