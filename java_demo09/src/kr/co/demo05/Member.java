package kr.co.demo05;

public class Member {

	private String name;
	private String password;
	
	public void setName(String name) throws UserException {
		if(name.contains("*")) {
			throw new UserException("사용자 이름에는 * 이 들어가면 안됩니다.");
		}
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPassword(String password) throws UserException {
		// 패스워드는 대문자/소문자/숫자/특수문자(!@#$%^&*)를 포함해야 합니다.
		if(validLowerCase(password)) {
			throw new PasswordInValidException("패스워드에 소문자가 포함되어 있지 않습니다.");
		} else if(!validSpecialChar(password)) {
			throw new PasswordInValidException("패스워드에 특수문자가 포함되어 있지 않습니다.");
		} else if(!validUpperCase(password)) {
			throw new PasswordInValidException("패스워드에 대문자가 포함되어 있지 않습니다.");
		} else if(!validNumber(password)) {
			throw new PasswordInValidException("패스워드에 숫자가 포함되어 있지 않습니다.");
		}
		this.password = password;
	}
		
	public String getPassword() {
		return this.password;
	}
	
	private boolean validUpperCase(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
				return true;
			}
		}
		return false;
	}
	
	private boolean validLowerCase(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
				return true;
			}
		}
		return false;
	}
	
	private boolean validNumber(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= '0' && password.charAt(i) <= '9') {
				return true;
			}
		}
		return false;
	}
	
	private boolean validSpecialChar(String password) {
		String specialChar = "!@#$%^&*";
		for(int i = 0; i < specialChar.length(); i++) {
			if(password.contains("" + specialChar.charAt(i))) {
				return true;
			}
		}
		return false;
	}
}
