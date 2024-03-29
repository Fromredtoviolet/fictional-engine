package kr.co.Exam04;

import java.util.Scanner;

public class Run {
	
	private Scanner sc = new Scanner(System.in);
	private Student student = new Student("서예인");

	public Run() {
		this.student.addSubject("국어", 78.8);
		this.student.addSubject("영어", 88.8);
		this.student.addSubject("수학", 83.4);
		this.student.addSubject("과학", 68.3);
	} // 초기 데이터 생성하는 부분. 생성자로 넣었지만, student객체 안에서 초기화시켜도 된다.
	
	private void printMenu() {
		System.out.println("1. 성적표 출력");
		System.out.println("2. 과목 성적 출력");
		System.out.println("3. 과목 성적 추가");
		System.out.println("4. 과목 성적 수정");
		System.out.println("5. 과목 성적 삭제");
		System.out.println("6. 프로그램 종료");
	}
	
	private void select(int number) {
		switch(number) {
		case 1:
			this.printAll();
			break;
		case 2:
			this.printSubject();
			break;
		case 3:
			// 과목 성적 추가 기능을 수행하는 메서드 호출
			break;
		case 4:
			// 과목 성적 수정 기능을 수행하는 메서드 호출
			break;
		case 5:
			// 과목 성적 삭제 기능을 수행하는 메서드 호출
			break;
		case 6:
			System.out.println("프로그램이 종료 됩니다.");
			System.exit(0); // 프로그램 종료
		default:
			// 메뉴 번호를 잘못 입력했을 경우
		}
	}
	
	public void printAll() {
		String result = this.student.getGradeTable();
		System.out.println(result);
	}
	
	public void printSubject() {
		while(true) {
			System.out.print("출력 할 과목명 : ");
			String name = sc.nextLine();
			
			if(name.equals("exit")) {
				break;
			}
			
			Subject subject = student.getSubject(name);
			if(subject != null) {
				System.out.printf("\t%s\n", subject.getName());
				System.out.printf("점수\t%s\n", subject.getScore());
				System.out.printf("등급\t%c\n\n", subject.getGrade());
			} else {
				System.out.println("출력 할 과목 정보가 없습니다.");
			}
			
		}
	}
	public void start() {
		while(true) {
			this.printMenu();
			System.out.print("메뉴 번호 입력 : ");
			
			int number = -1;
			if(sc.hasNextInt()) {		// ↓이건 그냥 개행 소진용
				number = sc.nextInt(); sc.nextLine(); 
				this.select(number); // ctrl키 누르고 메서드명 누르면 자동으로 이동	
			} else {
				sc.nextLine();
				continue;
			}
				
			
			System.out.println("초기 메뉴로 돌아가려면 Enter 입력!");
			sc.nextLine();
			
		}
	}

}
