package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RunTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		
		prop.setProperty("C", "INSERT"); //데이터 저장
		prop.setProperty("R", "SELECT"); //데이터 읽기
		prop.setProperty("U", "UPDATE"); //데이터 수정
		prop.setProperty("D", "DELETE"); //데이터 삭제
		
		try {
			prop.store(new FileOutputStream("resources/driver.properties"), "properties test");
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "properties test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("resources/dirver.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("dirver"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		*/
	}

}
