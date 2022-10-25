package kr.co.demo04;

public class Customer extends Person {

	@Override
	public String getFirstName() { 
		return getName().substring(0, 1);
	} // Person에서 메서드 선언만 하고 코드 구현을 안했으므로 자식이 강제로 구현해줘야함

	@Override
	public String getLastName() {
		return getName().substring(1);
	} // Person에서 메서드 선언만 하고 코드 구현을 안했으므로 자식이 강제로 구현해줘야함


}
