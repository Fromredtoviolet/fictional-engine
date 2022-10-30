package kr.co.demo05;

public class PasswordInValidException extends RuntimeException {
	
	public PasswordInValidException() { }
	
	public PasswordInValidException(String message) {
		super(message);
	}

}
