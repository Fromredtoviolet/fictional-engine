package kr.co.demo02;

public class Demo {

	public static void main(String[] args) {
		/*
		 * StringBuilder / StringBuffer
		 */
		StringBuilder sb = new StringBuilder();
		
		// append() 기존의 문자열에 또다른 문자열을 붙여준다.
		sb.append("문자열");
		System.out.println(sb.toString());
		
		sb.append(" append 로 추가");
		System.out.println(sb.toString());
		
		// capacity() 초기 크기를 알 수 있음
		int capacity = sb.capacity();
		System.out.println(capacity);
		
		// length()
		int length = sb.length();
		System.out.println(length);
		
		// delete() 지정한 위치의 문자열을 삭제한다.
		sb.delete(0, 4);
		System.out.println(sb.toString());
		
		// insert() (지정한 위치, 추가할 문자열)의 구조로 지정한 위치에 지정한 문자열을 삽입해준다.
		sb.insert(9, "문자열 ");
		System.out.println(sb.toString());
		
		// reverse() 역순으로 나온다.
		sb.reverse();
		System.out.println(sb.toString());
		
		// setLength()
		sb.setLength(length);
		System.out.println(sb.toString());
		
		// trimToSize()
		sb.trimToSize();
		capacity = sb.capacity();
		
		// indexOf(), replace(), charAt(), compareTo(), substring() 등은
		// 스트링 클래스와 동일한 기능으로 스트링빌더 클래스에도 존재한다.

	}

}
