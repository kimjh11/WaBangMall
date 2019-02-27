package kr.wabang.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	protected Connection con = null;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	//DB연결
	public void dbCon() {
		try {
			//Context생성
			Context ctx1 = new InitialContext();
			Context ctx2 = (Context) ctx1.lookup("java:comp/env");
			//DataSource 객체 생성
			DataSource ds = (DataSource) ctx2.lookup("jdbc/myoracle");
			//Connection 생성
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println("DB연결 에러"+e.getMessage());
		}
	}
	
	//DB닫기
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}catch(Exception e) {
			System.out.println("DB닫기 에러"+e.getMessage());
		}
	}
}
