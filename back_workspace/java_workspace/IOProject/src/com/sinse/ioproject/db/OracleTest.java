package com.sinse.ioproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class OracleTest {

	public static void main(String[] args) {
		// 오라클 접속하기
		/*
		 * 1) java언어가 데이터베이스를 핸들링 하기 위해서는 db를 제작한 벤더사에서 제공하는
		 * 구현체인 드라이버를 먼저 메모리에 로드해야 한다. 단, 주의! 일반 클래스처럼 new 할 수 없고, method 영역에
		 * 개발자가 직접 올려야함
		 */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // jvm의 메서드 영역에 개발자 직접 로드
			System.out.println("성공");
			
			// 원격지의 오라클에 접속
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "java", "1234");
				
				if(con != null ) {
					System.out.println("접속 성공");
					
//					// 접속이 성공된 이후, 원격지의 db 서버의 SQL 문을 네트워크를 통해 전송
//					String sql = "insert into member3(uid, pwd, email) values('scott', '3333', 'sss@daum.net')"; 
//					// Java Database Connectivity= 자바의 데이터베이스 연동 기술 및 지우너 패키지(java.sql 패키지에서..)
//					// JDBC 쿼리문 수행을 담당하는 인터페이스는 PreparedStatement
//					PreparedStatement pstmt;
				}else {
					System.out.println("접속 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}

}
