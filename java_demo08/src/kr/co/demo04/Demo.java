package kr.co.demo04;

public class Demo {

	public static void main(String[] args) {
		/*
		 * Wrapper 클래스
		 * 		- 문자열을 기본 자료형으로 변환해주는 클래스
		 * 		- 기본 자료형을 클래스로 만들어서 클래스처럼 다루어서 사용할 수 있게
		 * 		  도와주는 클래스
		 * 
		 * Wrapper 종류 (클래스니까 대문자로 시작할 것)
		 * 		Boolean, Byte, Character, Short, Integer, Long, Float, Double
		 */
		
		boolean bool1 = Boolean.parseBoolean("true");
		byte bt1 = Byte.parseByte("100");
		char ch1 = "가".charAt(0); // char만 유독 특이하게 charAt을 써야 함!
		short sh1 = Short.parseShort("100");
		int it1 = Integer.parseInt("100");
		long lg1 = Long.parseLong("100");
		float ft1 = Float.parseFloat("100");
		double db1 = Double.parseDouble("100");
		
		// 기본 자료형을 Wrapper 객체로 변환
		Boolean bool2 = Boolean.valueOf(bool1);
		Byte bt2 = Byte.valueOf(bt1);
		Character ch2 = Character.valueOf(ch1);
		Short sh2 = Short.valueOf(sh1);
		Integer it2 = Integer.valueOf(it1);
		Long lg2 = Long.valueOf(lg1);
		Float ft2 = Float.valueOf(ft1);
		Double db2 = Double.valueOf(db1);

	}

}
