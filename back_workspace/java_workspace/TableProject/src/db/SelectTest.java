package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// select 문 수행하기
public class SelectTest {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/dev";
		String user = "java";
		String pass = "1234";
		
		Connection con = null; // finally에서 닫기 위해서는 try의 지역변수이면 안됨
		PreparedStatement pstmt = null; // query 수행 객체 쿼리문 마다 1:1 대응됨
												// 3개의 쿼리를 수행할 경우 3개 만든다
		ResultSet rs = null;
		
		// 접속, 다른 언어와 달리 Connection 객체는 접속이 성공되면, 메모리에 올라오는 결과물
		// 접속 정보를 가진 책체이다.. 접속 시도 객체가 아니다.
		// select version()
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver load");
			
			con = DriverManager.getConnection(url, user, pass);
			if(con != null) {
				System.out.println("접속성");
				
				String sql = "select * from emp";
				pstmt = con.prepareStatement(sql); // pstmt 객체 생성
				
				// 쿼리 실행 (DML= select, insert, delete, DDL = create, drop, alter, DCL)
				// DML, DDL : executeUpdate(), select executeQuery()
				rs = pstmt.executeQuery();
				// 최초에 rs를 생성한 시점에서 커서가 첫번째 레코드 보다 위에 위치
				rs.next(); // 커서 한칸 전진
				
				
				while(rs.next()) {
					// 현재 커서가 위치한 곳에서의 ename 컬럼 값을 가져옴
					String ename = rs.getString("ename");
					// 급여
					int sal = rs.getInt("sal");
					// 업무job
					String job = rs.getString("job");
					// 입사일job
					String hiredate = rs.getString("hiredate");
					System.out.println("ename : " +ename+", sal : " +sal+", job : " +job+", hiredate : " +hiredate);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
