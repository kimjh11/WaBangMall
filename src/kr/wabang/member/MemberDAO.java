package kr.wabang.member;

import kr.wabang.util.DBConnection;

public class MemberDAO extends DBConnection implements MemberInterface  {

	@Override
	public int memberInsert(MemberVO vo) {
		//회원가입
		int cnt =0;
		try{
			dbCon();
			String sql = "insert into member(m_num, m_id, m_pwd, m_name, m_tel, m_email, m_zipCode, m_addr,"
					   + " m_addrDetail, m_addrReference, m_regdate) values(memberSq.nextVal,?,?,?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_pwd());
			pstmt.setString(3, vo.getM_name());
			pstmt.setString(4, vo.getM_tel());
			pstmt.setString(5, vo.getM_email());
			pstmt.setString(6, vo.getM_zipCode());
			pstmt.setString(7, vo.getM_addr());
			pstmt.setString(8, vo.getM_addrDetail());
			pstmt.setString(9, vo.getM_addrReference());
		
			System.out.println(vo.getM_id());
			System.out.println(vo.getM_pwd());
			System.out.println(vo.getM_name());
			System.out.println(vo.getM_tel());
			System.out.println(vo.getM_email());
			System.out.println(vo.getM_zipCode());
			System.out.println(vo.getM_addr());
			System.out.println(vo.getM_addrDetail());
			System.out.println(vo.getM_addrReference());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("회원가입 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int idCheck(String userid) {
		//아이디 중복 검사
		int cnt = 0;
		try{
			dbCon();
			String sql = "select count(m_id) from member where m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cnt = rs.getInt(1);
			}
			
		}catch(Exception e){
			System.out.println("아이디 중복 검사 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public void loginCheck(MemberVO vo) {
		//로그인 체크 (아이디/비밀번호)
		try{
			dbCon();
			String sql = "select m_id from member where m_id=? and m_pwd=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_pwd());
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo.setM_id(rs.getString(1));
				vo.setLoginStatus("Y");
			}
			
		}catch(Exception e){
			System.out.println("로그인 체크 에러"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public MemberVO myInfoSelect(String userid) {
		// 회원정보 수정 -선택
		MemberVO vo = new MemberVO();
		try{
			dbCon();
			String sql = "select m_id, m_pwd, m_name, m_tel, m_email, m_zipcode, m_addr, m_addrDetail, m_addrReference "
					+ " from member where m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo.setM_id(rs.getString(1));
				vo.setM_pwd(rs.getString(2));
				vo.setM_name(rs.getString(3));
				vo.setM_tel(rs.getString(4));
				vo.setM_email(rs.getString(5));
				vo.setM_zipCode(rs.getString(6));
				vo.setM_addr(rs.getString(7));
				vo.setM_addrDetail(rs.getString(8));
				vo.setM_addrReference(rs.getString(9));
			}
			System.out.println("===select====");
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));
			System.out.println(rs.getString(8));
			System.out.println(rs.getString(9));
			
		}catch(Exception e){
			System.out.println("회원정보 수정 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return vo;
	}

	@Override
	public int myInfoUpdate(MemberVO vo) {
		// 회원정보 수정 - 업데이트
		int cnt = 0;
		try{
			dbCon();
			String sql = "update member set m_name=?, m_tel=?, m_email=?, m_zipCode=?, m_addr=?, m_addrDetail=?, m_addrReference=? "
					+ "where m_id=? and m_pwd=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getM_name());
			pstmt.setString(2, vo.getM_tel());
			pstmt.setString(3, vo.getM_email());
			pstmt.setString(4, vo.getM_zipCode());
			pstmt.setString(5, vo.getM_addr());
			pstmt.setString(6, vo.getM_addrDetail());
			pstmt.setString(7, vo.getM_addrReference());
			pstmt.setString(8, vo.getM_id());
			pstmt.setString(9, vo.getM_pwd());
			
			System.out.println("===update====");
			System.out.println(vo.getM_name());
			System.out.println(vo.getM_tel());
			System.out.println(vo.getM_email());
			System.out.println(vo.getM_zipCode());
			System.out.println(vo.getM_addr());
			System.out.println(vo.getM_addrDetail());
			System.out.println(vo.getM_addrReference());
			System.out.println(vo.getM_id());
			System.out.println(vo.getM_pwd());
			
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("회원정보 수정 업데이트 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int myInfoDelete(String userid, MemberVO vo) {
		//회원 탈퇴
		int cnt =0;
		try{
			dbCon();
			String sql ="delete from member where m_id=? and m_pwd=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, vo.getM_pwd());
			
			System.out.println("===delete====");
			System.out.println(vo.getM_id());
			System.out.println(vo.getM_pwd());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("회원탈퇴 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}
	
}
