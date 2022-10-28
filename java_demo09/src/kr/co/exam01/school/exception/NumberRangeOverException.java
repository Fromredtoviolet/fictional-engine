package kr.co.exam01.school.exception;

public class NumberRangeOverException extends RuntimeException {
	
	public NumberRangeOverException() { 
		super("지정된 숫자 범위를 초과하였습니다.");
	}

	public NumberRangeOverException(String message) { 
		super(message);
	}
	
	public NumberRangeOverException(int min, int max) {
		super(String.format("지정된 숫자 범위(%d~%d)를 초과하였습니다.", min, max));
	}
	
}
