package kr.co.exam03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 과목 정보를 담기 위한 HashMap 컬렉션을 사용해 보세요.
		 * 다음의 과목명과 과목 점수가 HashMap 에 저장될 수 있게 하세요.
		 * 
		 * 과목명 : 국어, 영어, 수학, 과학, 사회, 체육, 미술
		 * 
		 * 과목명은 Key 가 됩니다.
		 * 과목 점수는 Value 가 되며, Double 형으로 임의의 점수를 저장하세요.
		 * 
		 * 모든 정보를 입력 후에는 평균과 총점을 구해서 출력하세요.
		 */
		
		
		HashSet<String> subjects = new HashSet<String>();
		subjects.add("국어"); subjects.add("영어");
		subjects.add("수학"); subjects.add("과학");
		subjects.add("사회"); subjects.add("체육");
		subjects.add("미술");
		
		HashMap<String, Double> datas = new HashMap<String, Double>();
		Random rand = new Random();
		for(String subject: subjects) {
			datas.put(subject, Double.valueOf(rand.nextInt(40) * rand.nextDouble() + 60));
		}
		
		System.out.println(datas);
		
		double sum = 0;
		double avg = 0;
		for(Double score: datas.values()) {
			sum += score;
		}
		avg = sum / datas.size();
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		
		
		/*
		HashMap<String, Double> subject = new HashMap<String, Double>();
		
		subject.put("국어", Double.valueOf(30.5));
		subject.put("영어", Double.valueOf(40.5));
		subject.put("수학", Double.valueOf(50.5));
		subject.put("과학", Double.valueOf(60.5));
		subject.put("사회", Double.valueOf(70.5));
		subject.put("체육", Double.valueOf(80.5));
		subject.put("미술", Double.valueOf(90.5));
		
		Double d1 = subject.get("국어");
		Double d2 = subject.get("영어");
		Double d3 = subject.get("수학");
		Double d4 = subject.get("과학");
		Double d5 = subject.get("사회");
		Double d6 = subject.get("체육");
		Double d7 = subject.get("미술");
		int size = subject.size();
		
		Double all = d1 + d2 + d3 + d4 + d5 + d6 + d7;
		Double avg = all / size;
		subject.put("총점", Double.valueOf(all));
		subject.put("평균", Double.valueOf(avg));
		
		System.out.printf("총점은 %.1f점이고 평균은 %.1f점이다.", all, avg);
		 */
	}

}
