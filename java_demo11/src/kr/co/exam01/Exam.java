package kr.co.exam01;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Exam {
	
	public static ArrayList<Integer> getLottoNumber() {
		Random rand = new Random();
		ArrayList<Integer> lottoNumber = new ArrayList<Integer>();
		
		while(lottoNumber.size() < 6) {
			Integer num = Integer.valueOf(rand.nextInt(45) + 1); // 인티저 객체로 저장
			if(!lottoNumber.contains(num)) {
				lottoNumber.add(num);
			}
		}
		Collections.sort(lottoNumber);
		return lottoNumber;
	}

	public static void main(String[] args) {
		/*
		 * 로또 번호 생성
		 * 		- 1 ~ 45 까지의 랜덤 번호를 생성하여 리스트에 담는다.
		 * 		- 중복된 번호 없이 리스트에 담기도록 한다.
		 * 		- 총 6개의 번호가 리스트에 저장되어야 한다.
		 * 		- 마지막에 출력할 때는 오름차순으로 정렬하여 출력되도록 한다.
		 */
		
		/*
		 * 위에서 생성한 로또 번호 6개를 한 세트라고 하자. 
		 * 
		 * 1. 사용자가 원하는 수의 세트로 로또 번호가 생성되어 파일에 저장될 수 있도록 한다.
		 * 2. 저장할 때 D:\\lotto.txt 파일로 저장되도록 한다.
		 * 3. 한 줄에 한 세트의 로또 번호가 출력되어야 한다.
		 * 4. 번호를 출력할 때 쉼표(,)를 구분자로 하여 출력되도록 해야 한다.
		 */
		
		File f = new File("D:\\lotto.txt");
		
		int count = 10; // 10번 반복한다는 임의 지정.
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))) { // 버퍼 보조 스트림
			for(int i = 0; i < count; i++) { // 10번까지 반복 수행
				ArrayList<Integer> lots = getLottoNumber(); // 미리 만들어둔 로또넘버를 불러와서 lots에 저장
				String strLots = lots.toString(); // 이 로또넘버를 문자열로 만들고
				strLots = strLots.substring(1, strLots.length() - 1); // 대괄호가 붙는걸 방지하기 위해 앞뒤 문자 잘라줌
				bw.write(strLots); // 이제 만들어둔 로또번호 문자열을 f 파일에 출력한다.
				bw.newLine(); // 개행
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
