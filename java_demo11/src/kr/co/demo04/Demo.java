package kr.co.demo04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) {
		/*
		 * Properties
		 * 프로그램을 만들어 초기 세팅을 할 때 사용
		 */
		Properties prop = new Properties();
		
		File f = new File("C:\\Users\\user2\\eclipse\\jee-2022-09\\eclipse\\configuration\\config.ini");
		
		try {
			prop.load(new BufferedReader(new FileReader(f)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop);
		System.out.println(prop.get("eclipse.application"));
		
		f = new File("C:\\Users\\user2\\eclipse\\jee-2022-09\\eclipse\\configuration\\config.ini.bak");
		try {
			prop.store(new BufferedWriter(new FileWriter(f)), "Comment"); // 내용 변경 후 저장하고 싶을 때 store 사용
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
