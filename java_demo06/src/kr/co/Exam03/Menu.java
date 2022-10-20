package kr.co.Exam03;

import java.util.Arrays;

public class Menu {
			//객체배열
	private Food food[];
	
	public Menu() {
		this.food = new Food[0];
	}
	
	/* Food 클래스를 끌고 오지 않을 때!
	   private String name[] = {"김밥", "라면"}; 
	   private int price[] = {3000, 2500};
	 * 여기서 값을 직접 입력해 초기화해두지 않는다면,
	 * private String name[];
	 * private int price[];
	 * public Menu() {
	 * 		this.name = new String[0];
	 * 		this.price = new int[0];
	 * }
	 * 라고 인스턴스화 시키면서 초기화해주면 된다.
	 */
	
	
	/**
	 * 이 메서드는 '메뉴' 객체에 저장된 데이터를 문자열로 만들어 반환하는 메서드이다.
	 * @return
	 * 	모든 메뉴 정보가 있는 문자열을 반환한다.
	 */
	public String getAll() {
		String str = "";
		for(int i = 0; i < this.food.length; i++) {
			Food f = this.food[i];
			str += String.format("%s\t%,d\n", f.name, f.price);
		}		// System.out.printf와 비슷함. 지정한 포맷대로 값을 반환하는 식
		return str;
	}
	
	
	/**
	 * 이 메서드는 메뉴 배열에 새로운 메뉴를 추가하기 위한 기능의 메서드이다.
	 * @param menuName : 음식 메뉴에 추가할 메뉴명
	 * @param price : 음식 메뉴에 추가할 메뉴의 가격
	 */
	public void add(String menuName, int price) {
		boolean isExists = this.findIndex(menuName) != -1 ? true : false; 
		if(!isExists) { // 중복체크 기능도 수행
		this.food = Arrays.copyOf(this.food, this.food.length + 1);
		this.food[this.food.length - 1] = new Food(menuName, price);
		
//		this.price = Arrays.copyOf(this.price, this.price.length + 1);
//		this.price[this.price.length - 1] = price;
		}
	}
	public void add(Food[] food) {
		for(int i = 0; i < food.length; i++) {
			this.add(food[i].name, food[i].price);
		}
	}
					// 가변길이매개변수
	public void add(String ... menuName) {
		for(int i = 0; i < menuName.length; i++) {
			this.add(menuName[i], 0);
		}
	}
	
	public void add(Food food) {
		this.add(food.name, food.price);
		// 메서드 오버로딩(OverLoadding)
		// 동일한 이름의 메서드를 여러개 작성하는 것.
		// 동일한 이름의 메서드는 만들 수 있다. (위의 add와 여기 이 add는 메서드 이름이 같다)
		// 단, 매개변수의 타입과 수량이 달라야한다. 그러나, 매개변수의 내용은 같더라도 자리가 다르다면 
		// (예시)(int price, String menuName) 다르게 인식되어 조건을 충족한다.
	}
	
	
	public boolean update(String menuName, int price) {
		/*for(int i = 0; i < this.name.length; i++) {
			if(this.name[i].equals(menuName)) {
				this.price[i] = price;
				return true;
			}
		} 이 for 구문을 아래의 파인드인덱스 이용으로 더 짧게 줄일 수 있다.*/
		int idx = this.findIndex(menuName);
		if(idx != -1) {
			this.food[idx].price = price;
			return true;
		}
		return false;
	}
	
	
	public void remove(String menuName) {
		int idx = this.findIndex(menuName);
		if(idx != -1) {
			for(int i = idx; i < this.food.length - 1; i++) {
				this.food[i] = this.food[i + 1];
			}
			this.food = Arrays.copyOf(this.food, this.food.length - 1);
		}
	}
	/*
	public void remove(String menuName) {
		boolean isExists = this.findIndex(menuName) != -1 ? true : false;
		
		boolean isExists = false; // 삭제할 데이터가 있는가? 없다. 없으므로 이 아래로는 동작 안함
		for(int i = 0; i < this.name.length; i++) {
			if(this.name[i].equals(menuName)) {
				isExists = true; // 있다. 있으므로 아래 if문의 동작으로 이어진다.
				break;
			}
		}
		if(isExists) {
		String tmpName[] = new String[this.name.length - 1];
		int tmpPrice[] = new int[this.name.length - 1]; 
		// 배열 복사에 쓰일 임시배열 생성.
		
			for(int i = 0, j = 0; i < this.name.length; i++) {
				if(!this.name[i].equals(menuName)) {
					tmpName[j] = this.name[i];
					tmpPrice[j] = this.price[i];
					j++; // 더 작은 배열의 값인 j는 삭제 후 늘어나야 하기 때문에 증감식이 여기!
				}
			}	
		this.name = tmpName;
		this.price = tmpPrice;
		}
	}*/

	
	/**
	 * 메뉴를 찾아서 해당하는 메뉴의 가격을 반환하는 메서드
	 * @param menuName
	 * @return
	 * -1 반환되면 해당 메뉴는 없는 메뉴입니다.
	 */
	/*
	public int getPrice(String menuName) {
		for(int i = 0; i < this.name.length; i++) {
			if(this.name[i].equals(menuName)) {
				return this.price[i];
			}
		}
		return -1; // 0으로 표기할 경우, 없는 메뉴의 값을 출력했을때 어? 0원인가? 할수있으므로.
	}
	* 다른 기능들과 계속 겹치는 for문 부분을 파인드인덱스를 이용하여 아래처럼 더 짧게 줄일 수 있다.
	*/
	public int getPrice(String menuName) {
		int idx = this.findIndex(menuName);
		return idx != -1 ? this.food[idx].price : idx;
	}
	
	
	private int findIndex(String menuName) {
		for(int i = 0; i < this.food.length; i++) {
			if(this.food[i].name.equals(menuName)) {
				return i;
			}
	}
		return -1; // 해당하지 않는다면 -1을 반환한다.
}
}
