package kr.wabang.member;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class MemberDAO extends DBConnection implements MemberInterface  {

	@Override
	public int memberInsert(MemberVO vo) {
		//ȸ������
		int cnt =0;
		try{
			dbCon();
			String sql = "insert into storemember(m_num, m_id, m_pwd, m_name, m_tel, m_email, m_zipCode, m_addr,"
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
			System.out.println("ȸ������ ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int idCheck(String userid) {
		//���̵� �ߺ� �˻�
		int cnt = 0;
		try{
			dbCon();
			String sql = "select count(m_id) from storemember where m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cnt = rs.getInt(1);
			}
			
		}catch(Exception e){
			System.out.println("���̵� �ߺ� �˻� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public void loginCheck(MemberVO vo) {
		//�α��� üũ (���̵�/��й�ȣ)
		try{
			dbCon();
			String sql = "select m_id from storemember where m_id=? and m_pwd=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_pwd());
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo.setM_id(rs.getString(1));
				vo.setLoginStatus("Y");
			}
			
		}catch(Exception e){
			System.out.println("�α��� üũ ����"+e.getMessage());
		}finally{
			dbClose();
		}
	}
	
	@Override
	public void adminloginCheck(AdminVO adminvo) {
		//���� �α���
		try{
			dbCon();
			String sql = "select adminId from admin where adminId=? and adminPwd=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, adminvo.getAdminId());
			pstmt.setString(2, adminvo.getAdminPwd());
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				adminvo.setAdminId(rs.getString(1));
				adminvo.setAdminloginStatus("Y");
			}
		}catch(Exception e){
			System.out.println("���� �α��� ����"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public MemberVO myInfoSelect(String userid) {
		// ȸ������ ���� -����
		MemberVO vo = new MemberVO();
		try{
			dbCon();
			String sql = "select m_id, m_pwd, m_name, m_tel, m_email, m_zipcode, m_addr, m_addrDetail, m_addrReference "
					+ " from storemember where m_id=?";
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
			System.out.println("ȸ������ ���� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return vo;
	}

	@Override
	public int myInfoUpdate(MemberVO vo) {
		// ȸ������ ���� - ������Ʈ
		int cnt = 0;
		try{
			dbCon();
			String sql = "update storemember set m_name=?, m_tel=?, m_email=?, m_zipCode=?, m_addr=?, m_addrDetail=?, m_addrReference=? "
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
			System.out.println("ȸ������ ���� ������Ʈ ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int myInfoDelete(String userid, MemberVO membervo) {
		//ȸ�� Ż��
		int membercnt =0;
		try{
			dbCon();
			String sql ="delete from storemember where m_id=? and m_pwd=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, membervo.getM_pwd());
			
			System.out.println("===delete====");
			System.out.println(membervo.getM_id());
			System.out.println(membervo.getM_pwd());
			
			membercnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("ȸ��Ż�� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return membercnt;
	}

	@Override
	public MemberVO findId(String email) {
		//���̵� ã��
		MemberVO vo = new MemberVO();
		try {
			dbCon();
			String sql = " select m_id from storemember where m_email = ? ";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	
				vo.setM_id(rs.getString(1));
			}
			
		}catch(Exception e){
			System.out.println("���̵�ã�� ����..."+e.getMessage());
		}finally {
			dbClose();
		}
		return vo;
	}

	@Override
	public MemberVO findPwd(String userid, String email) {
		//��й�ȣ ã��
		MemberVO vo = new MemberVO();
		try {
			dbCon();
			String sql = " select m_pwd from storemember where m_email = ? and m_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setM_pwd(rs.getString(1));
			}
			
		}catch(Exception e){
			System.out.println("���ã�� ����..."+e.getMessage());
		}finally {
			dbClose();
		}	
		return vo;
	}
}
