package t1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class JbDAO {
	Connection conn = null;  //Connection : 특정 데이터 원본과 연결된 커넥션을 나타내고 SQL문장을 정의하고 실행시킬수있는 Statement객체 생성할때 사용.
	PreparedStatement pstmt = null;  // sql문 실행
	ResultSet rs = null; // 실행 결과값
	
	String sql = "";

	
	JbVO vo = null;
	public JbDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jb";
			String user = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}
	}
	//Database Close
	public void dbClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
		
	// preparedstatement객체 Close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
		
	// resultset객체 close
	public void rsClose() {
		try {
			if(rs != null) {
				rs.close();
				pstmtClose();
			}
		} catch (Exception e) {}
	}
	public void JbOrder(JbVO vo) { // 결제내역등록 ( 결제완료 )
		try {
			sql = "insert into jborder value (default,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMenu());
			pstmt.setInt(3, vo.getMenupri());
			pstmt.setString(4, vo.getMenubill());
			pstmt.setString(5, vo.getMenutake());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getList() { // 결제내역 불러오기 (전체)
		Vector vData = new Vector();
		try {
			sql = "select * from jborder order by idx";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				@SuppressWarnings("rawtypes")
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("menu"));
				vo.add(rs.getInt("menupri"));
				vo.add(rs.getString("menubill"));
				vo.add(rs.getString("menutake"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getSearch(String combo, String txt) { // 결제내역 불러오기 (부분)
		Vector vData = new Vector();
		try {
			sql = "select * from jborder where "+combo+" like ?";
			pstmt = conn.prepareStatement(sql);
			if(!combo.equals("idx")) {
				pstmt.setString(1, "%"+txt+"%");
			}
			else {
				pstmt.setInt(1, Integer.parseInt(txt));
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("menu"));
				vo.add(rs.getInt("menupri"));
				vo.add(rs.getString("menubill"));
				vo.add(rs.getString("menutake"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	public void getCreate(JbVO vo) {
		try {
			sql = "insert into jbmember value (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNameM());
			pstmt.setString(2, vo.getBirthM());
			pstmt.setString(3, vo.getGenderM());
			pstmt.setString(4, vo.getPhoneM());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getListM() {
		Vector vData = new Vector();
		try {
			sql = "select * from jbmember order by idx";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("birth"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("phone"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getSearchM(String comboM, String txt) {
		Vector vData = new Vector();
		try {
			sql = "select * from jbmember where "+comboM+" like ?";
			pstmt = conn.prepareStatement(sql);
			if(!comboM.equals("idx")) {
				pstmt.setString(1, "%"+txt+"%");
			}
			else {
				pstmt.setInt(1, Integer.parseInt(txt));
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("birth"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("phone"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	public void getClear() {
		try {
			sql = "delete from jborder";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
	}
	public void getClearM() {
		try {
			sql = "delete from jbmember";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
	}
	public void getDelete(JbVO vo) {
		try {
			sql = "delete from jbmember where idx = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getIdx());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
	}
	
}
