package kr.co.exam02;

public class Admin extends Staff{
	
	public Member removeRole(Staff staff) {
		Member member = new Member();
		member.setName(staff.getName());
		member.setAge(staff.getAge());
		return member;
	}
	
	public Staff addRole(Member member) {
		Staff staff = new Staff();
		staff.setName(member.getName());
		staff.setAge(member.getAge());
		return staff;
	}
	
	@Override
	public String toString() {
		return "Admin [getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}
}
