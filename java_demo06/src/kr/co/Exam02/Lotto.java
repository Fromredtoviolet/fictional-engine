package kr.co.Exam02;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	private int id; // 회차
	private int numbers[]; // 로또번호 배열
	private int bonus; // 보너스 번호
	
	public Lotto(int id) {
		this.id = id;				// 생성자로 회차 번호를 넣으면 회차 번호 확정.
		this.numbers = new int[7];	// 로또 번호 배열의 크기는 7이라고 초기화.(보너스번호 합친 크기)
	}
	
	public void generate() {
//		System.out.println("1 ~ 46 사이의 로또 번호 6개 생성");
//		System.out.println("보너스 번호 1개 생성");
//		클래스 구조를 만드는 것이 중점이므로, 상세한 로직 구현까지는 못 하겠다면 위의 주석처리한 출력구문이라도 써두자.
		Random rand = new Random();
		for(int i = 0; i < numbers.length;) { // 중복검사 후에 증가해야하기 때문에 증감식 생략
			int num = rand.nextInt(46) + 1;
			boolean duplicate = false;
			for(int j = 0; j < i; j++) {		// 중
				if(this.numbers[j] == num) {	// 복
					duplicate = true;			// 검
					break;						// 사
				}
			}
			if(!duplicate) {
			this.numbers[i] = num;
			i++;
			}
		}
		this.bonus = this.numbers[this.numbers.length - 1]; // 넘버스 배열의 마지막 칸이 보너스 번호.
		this.numbers = Arrays.copyOf(this.numbers, 6); // 보너스 번호 제외하고 앞에 6칸이 찐 넘버스.
	}
	public String getLotto() {
		String str = "";
		for(int i = 0; i < this.numbers.length; i++) {
			str += this.numbers[i] + ", ";
		}
		return str + this.bonus;
	
		
	}
}
