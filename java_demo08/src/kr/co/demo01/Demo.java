package kr.co.demo01;

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {
		/*
		 * String 관련 클래스
		 * 		- String : 문자열 클래스로 문자열 데이터를 다루기 위해 사용한다.
		 * 			수정 불가능(불변타입) 으로 데이터 수정 시 원본 데이터를 복사하여
		 * 			새로운 문자열 데이터로 만드는 형식으로 사용
		 * 
		 * 		- StringBuilder : 문자열 클래스로 String 의 불변타입을 변경가능으로
		 * 			사용할 수 있게 만들어진 클래스이다.
		 * 			Thread Safe 기능을 제공하지 않음.
		 * 
		 * 		- StringBuffer : StringBuilder 클래스와 동일한 기능을 제공
		 * 			Thread Safe 기능을 제공함.
		 * 			(Thread Safe 기능은 멀티쓰레드 작업에 활용할 때 공유 자원에 대한
		 * 			안정성을 높여 주기 위해 사용하는 기능. 그래서 성능이 좀 떨어지는 단점.
		 * 			the method synchronizes on it.)
		 */
		
		// 문자열 생성 방법
		String str1 = "문자열";
		String str2 = new String("문자열");
		String str3 = new String(new char[] {'문', '자', '열'});
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		// charAt() : 문자열에서 매개변수로 전달한 정수값의 위치에 해당하는 문자를 반환하는 메서드
		// 			  문자열도 배열처럼 0번부터 시작하는 위치값(인덱스)가 있다.
		for(int i = 0; i < str1.length(); i++) { // length() 메서드임!! 배열의 length변수와 헷갈리지 말 것.
			char ch = str1.charAt(0); 
			System.out.println(ch);
		}
		
		// codePointAt() : 문자열에서 매개변수로 전달한 정수값의 위치에 해당하는 문자의 문자코드를 반환하는 메서드
		//				   쉽게 말해, 아스키코드?
		for(int i = 0; i < str1.length(); i++) {
			int code = str1.codePointAt(0);
			System.out.println(code + "|" + (char)code);
		}
		
		// 사전순으로 봤을 때 어떤 문자가 더 앞에 있는지 알수있다.
		// 앞에 작성한 문자열을 기준으로, 콘솔창에 결과가 마이너스가 나오면 기준 문자열이 사전에서 더 앞에 있음
		// 즉! 양수냐 음수냐를 보면 됨. 작은 애(먼저인 애)가 큰 애(늦게인 애)를 빼면 음수니까~ 반대면 양수~
		str1 = new String("가");
		str2 = new String("나");
		int compare = str1.compareTo(str2);
		System.out.println(compare);
		compare = str2.compareTo(str1);
		System.out.println(compare);
		
		System.out.println(str1.codePointAt(0));
		System.out.println(str2.codePointAt(0));
		
		// 대소문자 무시. Case는 대소문자 얘기하는 단어고 Ignore는 무시
		str1.compareToIgnoreCase(str3);
		
		// concat() : 문자열을 결합시켜서 보여주는 메서드. '+'같은거라고 생각하면 될 듯?
		str1 = new String("가");
		str2 = new String("나");
		str3 = str1.concat(str2);
		System.out.println(str3);
		
		// contains() : 문자열에 "해당 내용"이 포함되어 있는지 참과 거짓을 가리는 메서드
		//				대표적인 사용 예시로 비밀번호 생성시 영문자 특수기호 숫자 포함해서 만들어야하는 것!
		str1 = new String("이 메서드는 contains 예제 입니다.");
		boolean isContains = str1.contains("contains");
		System.out.println(isContains);
		
		isContains = str1.contains("컨테인");
		System.out.println(isContains);
		
		// contentEquals() : 똑같은 문장일 경우 true. 조금이라도 불일치하면 false.
		str1 = new String("동일한 내용이 있는지 검사하는 메서드");
		boolean isEquals = str1.contentEquals("동일한 내용이 있는지");
		System.out.println(isEquals);
		
		// endsWith(), startWith() : 종료 문자열 / 시작 문자열과 일치하는지 가리는 메서드
		str1 = new String("startsWith(), endsWith() 메서드 예제");
		boolean isEnds = str1.endsWith("end");
		boolean isStarts = str1.startsWith("start");
		System.out.println(isEnds + "|" + isStarts);
		
		// toUpperCase(), toLowerCase() : 대문자로만 / 소문자로만 바꿔주는 메서드.
		str2 = str1.toLowerCase();
		System.out.println(str2);
		
		str2 = str1.toUpperCase();
		System.out.println(str2);
		
		// indexOf() : "해당 내용"이 문자열에서 몇 번 인덱스에 위치하는지 그 시작점이 정수값으로 반환.
		// 숫자로 된 문자의 코드번호를 매개변수로 써도 된다. 코드번호 모르겠으면 걍 ((int)'문')처럼 형변환
		// lastIndexOf() 는 뒤에서부터 위치 자릿수 셈.
		str1 = new String("indexOf() 메서드 사용 예제로 이 메서드는 특정 문자열의 위치를 알려주는 메서드 입니다.");
		int index = str1.indexOf("메서드");
		System.out.println(index);
		index = str1.indexOf("메서드", 11); // 10번까진 찾았으니 11번 위치부터 다시 탐색해라.
		System.out.println(index);
		index = str1.indexOf("메서드", 24); // 23번까진 찾았으니 24번 위치부터 다시 탐색해라.
		System.out.println(index);
		index = str1.indexOf("메서드", 46); // -1이 출력되면 해당하는 문자열이 더이상 없다는 뜻. 크기 초과.
		System.out.println(index);
		
		// 문자열에서 사용자가 지정한 문자열이 몇개 있는지 출력하시오.
		String str = new String("오늘의 코딩 수업은 코딩 초보도 따라가기 수월하다.");
		int count = 0;
		index = 0;
		while(true) {
			index = str.indexOf("코딩", index);
			if(index == -1) {
				break;
			} else {
				index++; count++;
			}
		}
		System.out.println("str 문자열에서 \"코딩\" 단어는 " + count + "개 있습니다.");
		
		// isBlank()는 공백(Space)을 문자열로 취급 안 함. isEmpty()는 공백을 문자열 취급.
		// 빈 문자열인지 아닌지 판단할 때 공백에 관해 세부적으로 나뉘는 메서드들이다.
		str1 = new String("");
		boolean isBlank = str1.isBlank();
		boolean isEmpty = str1.isEmpty();
		System.out.println(isBlank + "|" + isEmpty);
		
		str1 = new String(" ");
		isBlank = str1.isBlank();
		isEmpty = str1.isEmpty();
		System.out.println(isBlank + "|" + isEmpty);
		
		str1 = new String("\n");
		isBlank = str1.isBlank();
		isEmpty = str1.isEmpty();
		System.out.println(isBlank + "|" + isEmpty);
		
		// lines()는 반환타입이 특이하고 최근 버전부터 나온 기능이라 초보는 비추... split()을 쓰는게 더 낫지 않을까?
		str1 = new String("문자열에\n개행이 있으면\n개행을 기준으로\n분리하는 메서드");
		Stream<String> stream = str1.lines();
		Object objArr[] = stream.toArray();
		
		for(int i = 0; i < objArr.length; i++) {
			String s = (String)objArr[i];
			System.out.println(i + 1 + "번째 줄 : " + s);
		}
		
		// split()은 매개변수로 전달하는 구문 문자열을 기준으로 분리하는 메서드. 
		// 응용하면 스캐너로 사용자 입력을 받을 때 정수값만 공백을 구분자로 받아서 문자열 배열에 저장할 수 있다.
		String strArr[] = str1.split("\\n"); // <- "이스케이프\n" 이라는 의미
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(i + 1 + "번째 줄 : " + strArr[i]);
		}
		str1 = new String("split 메서드는 매개변수로 전달하는 구문 문자열을 기준으로 분리하는 메서드");
		strArr = str1.split(" "); // 공백을 기준으로 분리.
		System.out.println(Arrays.toString(strArr));
		
		strArr = str1.split(" ", 3); // limit개만 나오게 배열의 크기를 정한다.
		System.out.println(Arrays.toString(strArr));
		
		// repeat()는 입력한 정수만큼 문자열을 반복한다. 참고로 자바11 이상부터 가능.
		str1 = new String("Hell!");
		str1 = str1.repeat(5);
		System.out.println(str1);
		
		// replace(A, B); 일 때 A의 내용을 B로 바꿔준다.
		// 설명에 뜨는 CharSequence는 String 이라고 생각하면 편함. regex는 정규표현식
		str1 = new String("문자열의 일부를 변경하기 위한 문자열 메서드 입니다.");
		str2 = str1.replace("문자열", "String");
		System.out.println(str2);
		
		
		// strip()은 문자열의 공백을 제거하는 메서드. 얘도 자바11부터 생겼다.
		str1 = new String("    문자열의 앞 뒤로 존재하는 공백을 제거    ");
		
		str2 = str1.strip(); // 문자열의 앞뒤 공백을 제거
		System.out.println("|" + str2 + "|");
		
		str2 = str1.stripLeading(); // 문자열 앞 공백을 제거
		System.out.println("|" + str2 + "|");
		
		str2 = str1.stripTrailing(); // 문자열 뒤 공백을 제거
		System.out.println("|" + str2 + "|");
		
		str2 = str1.trim(); // 11ver 이전에는 strip이 아닌 trim을 씀
		System.out.println("|" + str2 + "|");
		
		
		//
		str1 = new String("문자열 자르기 위한 메서드");
		str2 = str1.substring(4); // 문자 위치값(인덱스) 4번 이후부터 잘라서 저장한다.
		System.out.println(str2);
		
		str2 = str1.substring(8, 10); // 8번부터 10번까지 자른다.
		System.out.println(str2);
		
		
		// ↑ 인스턴스 메서드. str1이라는 위에 만들어둔 인스턴스를 가져다 씀.
		// ↓ 클래스 메서드. 정의가 필요 없이 그냥 클래스명(String) 붙여서 메서드 가져다 씀.
		//	 커서 댔을 때 뜨는 메서드 설명에 보면 메서드 아이콘에 Static을 뜻하는 S가 붙어있다.
		
		// String.format()은....printf()의 활용 버전?
		str1 = String.format("%s %d %f", "문자열포맷", 1234, 12.34);
		System.out.println(str1);
		
		// String.join(결합 문자, 데이터, 데이터 ...)의 형식으로 문자열 데이터를 결합하는 메서드
		str1 = String.join(", ", "가", "나", "다");
		System.out.println(str1);
		
		// String.valueOf()는 다른 타입을 문자열로 형변환 시켜주는 메서드.
		str1 = String.valueOf(true);
		System.out.println(str1);
		
		str1 = String.valueOf(10);
		System.out.println(str1);
		
		str1 = String.valueOf(12.34);
		System.out.println(str1);
		
		
	}

}
