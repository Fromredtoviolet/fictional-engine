package kr.co.exam05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;

import kr.co.exam04.Score;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 컬렉션에 다른 컬렉션을 담아서 사용하기
		 * 
		 * ArrayList 에 과목 정보들이 있는 HashMap 컬렉션을 담아서 사용해보세요.
		 * 
		 * HashMap에는 다음의 과목명과 과목 점수가 저장될 수 있게 하세요.
		 * 
		 * 과목명 : 국어, 영어, 수학, 과학, 사회, 체육, 미술
		 * 
		 * 과목명은 Key 가 됩니다.
		 * 과목 점수는 Value 가 되며, Score 객체로 임의의 점수와 등급이 저장되게 합니다.
		 * 
		 * 총 5개의 HashMap을 ArrayList에 담아놓고 ArrayList에 있는 HashMap 별로
		 * 평균과 총점을 구해서 출력하세요.
		 */
		
		HashSet<String> subjects = new HashSet<String>();
		subjects.add("국어"); subjects.add("영어");
		subjects.add("수학"); subjects.add("과학");
		subjects.add("사회"); subjects.add("체육");
		subjects.add("미술");
		
		// 리스트<해쉬맵<문자열, 스코어 객체>>. 리스트 안에 해쉬맵, 해쉬맵 안에 문자열과 스코어 객체를 담아 사용 준비.
		ArrayList<HashMap<String, Score>> datas = new ArrayList<HashMap<String, Score>>();
		// 이 datas는 해쉬맵 'data'가 배열처럼 담겨질 리스트. 제네릭타입으로 구분해준다. 
		
		Random rand = new Random();
		
		for(int i = 0; i < 5; i++) { // data를 5번 생성하기 위해 반복문을 사용
			HashMap<String, Score> data = new HashMap<String, Score>();
			for(String subject: subjects) {
				double score = Double.valueOf(rand.nextInt(40) * rand.nextDouble() + 60);
				data.put(subject, new Score(score));
			}
			datas.add(data);
		}
		
		for(HashMap<String, Score> data: datas) {
			System.out.println(data);
		}
		
		
		// 총점과 평균을 구해서 HashMap 에 저장
		for(HashMap<String, Score> data: datas) {
			double sum = 0;
			double avg = 0;
			for(Entry<String, Score> e: data.entrySet()) {
				sum += e.getValue().getScore();
			}
			avg = sum / data.size();
			data.put("총점", new Score(sum));
			data.put("평균", new Score(avg));
		}
		
		int i = 0;
		for(HashMap<String, Score> data: datas) {
			System.out.print(++i + "번 학생의 총점:" + data.get("총점") +", ");
			System.out.println("평균:" + data.get("평균"));
		}
	}

}

		