package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.kh.model.vo.Member;

//DAO(Data Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
public class MemberDao {

	/**
	 * 사용자가 입력한 정보들을 db에 추가시켜주는 메소드
	 * @param m : 사용자가 입력한 값들이 담겨있는 Member객체
	 * @return : insert문 실행 후 처리된 행수
	 * 
	 * 
	 * */
	public void insertMember(Member m) {
		//insert문 => 처리된 행수(int) => 트랜잭션
		
		//필요한 변수를 먼저 세팅
		int result = 0; // 처리된 결과(처리된 행수)를 받아줄 변수
		Connection conn = null; // 연결된 db정보를 담는 객체
		PreparedStatement stmt = null; //완성된 sql문 전달해서 곧바로 실행후 결과를 받는 객체
		
		
		//실행할sql문 
		// 
		
//		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, " +
//		 "'" + m.getUserId()   + "'," +
//		 "'" + m.getUserPwd()  + "'," +
//		 "'" + m.getUserName() + "'," +
//		 "'" + m.getGender()   + "'," +
//		 	   m.getAge()      + ", " +
//		 "'" + m.getEmail()    + "'," +
//		 "'" + m.getPhone()    + "'," +
//		 "'" + m.getAddress()  + "'," +
//		 "'" + m.getHobby()    + "'," + "SYSDATE)";
		

		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
	
	//1)JDBC Driver등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2) connection 객체 생성
		conn = DriverManager.getConnection("jdbc:oracl:thin:@localhost:1521:xe", "JDBC", "JD")
	
		//3) Statement객체 생성
		pstmt = conn.prepareStatement(sql);// 아직 미완성sql문으로 ? 를 전부 채워줘야한다.
		pstmt.setString(1, m.getUserId());
		pstmt.setString(2, m.getUserPwd());
		pstmt.setString(3, m.getName());
		pstmt.setString(4, m.getGender());
		pstmt.setInt(5, m.getAge());
		pstmt.setString(6, m.getEmail());
		pstmt.setString(7, m.getPhone());
		pstmt.setString(8, m.getAddress());
		pstmt.setString(9, m.getHObby());
		
		
		//4,5) sql문 전달하면서 실행 후 값 받아오기
		
		result.pstmt.executeUpdate();
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	 catch(SQLException e) {
		e.printStackTrace(); 
	 }finally
		
	}

}
