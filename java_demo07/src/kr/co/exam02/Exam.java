package kr.co.exam02;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 회원 관리를 위한 프로그램을 만들기 위해 다음의 객체 정보가 필요하다.
		 * 		Member : 모든 일반 회원은 해당 객체를 통해 다루어진다.
		 * 				 일반 회원은 게시글쓰기, 게시글보기, 게시글수정 작업만
		 * 				 할 수 있다.
		 * 		Staff : 스태프는 일반 회원들이 작성한 글을 삭제할 수 있는 작업을
		 * 				가진다.
		 * 		Admin : 관리자는 스태프 권한 제거 및 추가, 멤버 가입 및 탈퇴의
		 * 				작업을 할 수 있다.
		 * 
		 * - 위 모든 객체는 이름, 나이 정보를 가지고 있다. 
		 * - 위 관계를 파악하여 클래스의 상속, 오버로딩, 오버라이딩, 다형성을 적용하여
		 * 	 다루어 본다.
		 * - 실제 프로그램을 구현하는 것 아님.
		 * - 구현할 메서드는 단순 출력문이 동작하도록 하세요.
		 * 	(예시. public void write() {System.out.println("글 작성함")} )
		 */
		Person p1 = new Member();
		p1.setName("홍길동"); p1.setAge(23);
		
		Person p2 = new Staff();
		p2.setName("김동후"); p2.setAge(24);
		
		Person p3 = new Admin();
		p3.setName("이종권"); p3.setAge(25);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		Person pArr[] = new Person[3];
		pArr[0] = p1; pArr[1] = p2; pArr[2] = p3;
		
		System.out.println(p3 instanceof Admin);
		System.out.println(p3 instanceof Staff);
		System.out.println(p3 instanceof Member);
		System.out.println(p3 instanceof Person);
		
		System.out.println(p1);
		
		Member m1 = (Member)p1;
		Admin a1 = (Admin)p3;
		p1 = a1.addRole(m1);
		
		System.out.println(p1);
		
		for(int i = 0; i < pArr.length; i++) {
			if(pArr[i] instanceof Admin) { // 가장 하위(자식)인 Admin부터 작성하는 규칙. 제일 포함하고 있는게 많으니까.
				Admin a = (Admin)pArr[i];
				// a.addRole();
				// a.removeRole();
			} else if(pArr[i] instanceof Staff) {
				Staff s = (Staff)pArr[i];
				s.delete();
			} else if(pArr[i] instanceof Member) {
				Member m = (Member)pArr[i];
				m.write(); // ↑ 이 때 다운캐스팅을 하는 이유! write/view/update 메서드는 자식 객체인
				m.view();  // member의 고유 메서드이다. 이 고유 메서드를 사용하기 위해서는 member로  
				m.update();// 객체를 맞춰줘야 한다. 그러므로 자식 객체인 member로 다운캐스팅을 한 것.
			}  
		}	  
	}		  

}


