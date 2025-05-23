package db;
/* MySQL 연동해보기
*/
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

class DBTest
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String mysqlDriver = "com.mysql.cj.jdbc.Driver";
		String oracleDriver = "oracle.jdbc.driver.OracleDriver";
		
		String mysqlUrl = "jdbc:mysql://localhost:3306/dev";
		String mysqlId = "root";
		String mysqlPass = "1234";
		
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String oracleId = "java";
		String oraclePass = "1234";
		
		
		// 제어하기를 원하는 드라이버 먼저 로드(method 영역)
		try {
			// 1단계 ) 드라이버 로드
			
			//# MySQL
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			//#Oracle
			Class.forName(oracleDriver);
			System.out.println("드라이버 로드 성공.");
			
			// 2단계 ) 접속
			
			//# MySQL
			//String url = mysqlUrl;
			//String id = mysqlId;
			//String pass = mysqlPass;
			
			//#Oracle
			String url = oracleUrl;
			String id = oracleId;
			String pass = oraclePass;
			
			// Connection 이란? 접속 성공 후 그 접속 정보를 가진 인터페이스임
			// 이 객체가 null이면 접속 실패
			con = DriverManager.getConnection(url, id, pass);
			if (con == null)
			{
				System.out.println("실패");
			} else {
				System.out.println("성공");
				// 접속이 성공된 이후, 원격지의 db 서버의 SQL 문을 네트워크를 통해 전송
				
				//# MySQL
				//String sql = "insert into member3(uid, pwd, email) values('scott', '3333', 'sss@daum.net')";
				
				//#Oracle
				String sql = "insert into member3(member3_id, id, pwd, email)";
				sql = sql + " values(seq_member3.nextval, 'James', '3333', 'jjj@gmail.com')";
				
				// Java Database Connectivity= 자바의 데이터베이스 연동 기술 및 지우너 패키지(java.sql 패키지에서..)
				// JDBC 쿼리문 수행을 담당하는 인터페이스는 PreparedStatement
				
				// 접속이 성공된 이후에 쿼리문 수행이 가능하므로 ,pstmt 객체의 인스턴스는
				// Connection 인터페이스로부터 얻어야함
				pstmt = con.prepareStatement(sql);
				// 준비된 문장으로 쿼리 실행
				int result = pstmt.executeUpdate(); // DML 수행 시 이 메서드를 사용해야 함.
				
				if(result > 0){
					System.out.println("result 등록 성공");
				}else {
					System.out.println("result 등록 실패");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch(SQLException e) {
			e.printStackTrace(); // 에러 순서를 스택 순서로 출력 (개발자를 위한 메시지
		} finally {
			/* DB와 스트림과 같은 자원을 차지하는 기술은 사용 후 반드시 닫아야 함.
				안 닫으면 메모리를 계속 확보하고 있다..
				만일 웹서버에 디 닫지 않은 코드가 올라온다면.. 동시 자원이 다수 생성.. */
			if(pstmt != null) {
				try{
					pstmt.close();
				} catch(SQLException e) {
					e.printStackTrace(); // 에러의 원인을 스택 구조로 출력(for 개발자)
				}
			}
			
			if(con != null) {
				try{
					con.close();
				} catch(SQLException e) {
					e.printStackTrace(); // 에러의 원인을 스택 구조로 출력(for 개발자)
				}
			}
		}
	}
}
