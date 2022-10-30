package kr.co.demo01;

public class Demo {

	public static void main(String[] args) {
		/*
		 * 시스템 에러는 내가 어찌 할 수 없는 컴퓨터의 에러
		 * 컴파일 에러는 이클립스가 빨간줄 표시해주는 문법적 에러. 아예 실행이 안 됨.
		 * 런타임 에러가 앞으로 예외처리로 해결해야 할 것들!
		 * 
		 * 익셉션에 관련하여 빨간줄이 떴을 때 커서를 대보면,
		 * throws는 그냥 처리를 미룬거라 언젠가는 해결해줘야함
		 * with try/catch 가 제대로 예외처리를 하는 것.
		 * 
		 * 에러 메세지가 출력될 때, 자바나 이클립스의 에러는 문제가 아니다. 문제는 나다!
		 * 위에서부터 읽으면서 내가 만든 패키지or클래스 관련해서 뜨는 에러 메시지를 찾아가야 한다.
		 * 코드를 추적하고 싶다면 아래서부터 읽으면 된다.
		 * 
		 * 캐치는 익셉션이 발생할때만
		 * 파이널리는 발생하든 말든~
		 */
		int arr[];
		
		try {
			arr = new int[-1];
			arr[0] = 10;
			arr[1] = 20;					// ↓ 객체 e. 지역변수라서 블럭 안에서는 또 쓸 수 있다.
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace(); // <- 에러 프린트하는 메서드
			System.out.println("인덱스 범위를 벗어 났습니다.");
		} catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기를 음수로 사용했습니다.");
		}// 에러 내용 여러개 처리하기 귀찮거나 뭔지 모르겠을땐! catch(Exception e) 를 쓴다.
		 // 다형성 때문에 실행해보면 에러내용 프린트 잘 됨.
		
		System.out.println("정상 종료!!!");

	}

}
