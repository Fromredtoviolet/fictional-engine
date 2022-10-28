package kr.co.exam01.school.exception;

public class NegativeNumberException extends RuntimeException {

	public NegativeNumberException() {
		super("음수를 출력할 수 없습니다.");
	}
	
	public NegativeNumberException(String message) {
		super(message);
	}
}
