package kr.co.demo05;

public class Demo {

	public static void main(String[] args) throws UserException {
		/*
		 * 사용자 정의 예외 작성
		 */
		Member m = new Member();
		
		m.setName("홍길동");
		m.setPassword("abc123");
		System.out.println(m.getName());
		System.out.println(m.getPassword());

	}

}
