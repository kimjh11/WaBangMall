package kr.wabang.mypage;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class MyPageDAO extends DBConnection implements MyPageInterface {

	//주문목록
	public List<OrderVO> getAllOrder(String userid) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			dbCon();
			String sql = " select m.m_id, o.o_num, o.i_code,o.o_selectOpt,o.o_count, "
					+ " to_char(o.o_date,'YYYY-MM-DD'), "
					+ " m.m_zipCode, m.m_addr, m.m_addrDetail,"
					+ "	o.o_deposit, o.o_delivery "
					+ " from member m join orderList o "
					+ " on m.m_id=o.m_id "
					+ " where m.m_id=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setM_id(rs.getString(1));
				vo.setO_num(rs.getString(2));
				vo.setI_code(rs.getString(3));
				vo.setO_selectOpt(rs.getString(4));
				vo.setO_count(rs.getInt(5));		
				vo.setO_date(rs.getString(6));
				vo.setM_zipCode(rs.getInt(7));
				vo.setM_addr(rs.getString(8));
				vo.setM_addrDetail(rs.getString(9));
				vo.setO_deposit(rs.getString(10));
				vo.setO_delivery(rs.getString(11));
							
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("주문 목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	//문의목록
	public List<DepositVO> getAllDeposit(String userid) {
		List<DepositVO> list = new ArrayList<DepositVO>();
		try {
			dbCon();
			String sql = " select q.q_num, q.m_id, q.q_title, q.q_content, "
					+ " to_char(q.q_regdate,'YYYY-MM-DD') "
					+ " from member m join question q "
					+ " on m.m_id=q.m_id "
					+ " where q.m_id=? "
					+ " order by q.q_regdate desc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DepositVO vo = new DepositVO();
				vo.setQ_num(rs.getInt(1));
				vo.setM_id(rs.getString(2));
				vo.setQ_title(rs.getString(3));
				vo.setQ_content(rs.getString(4));
				vo.setQ_regdate(rs.getString(5));
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("질문 목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	//결제완료
	public int updateDeposit(String userid,String deposit, String i_code) {
		int cnt = 0;
		try {
		dbCon();
		String sql = " update orderList set o_deposit = ?, o_fix = sysdate "
				+ " where m_id=? and i_code=? ";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, deposit);
		pstmt.setString(2, userid);
		pstmt.setString(3, i_code);
		pstmt.executeUpdate();
		cnt = pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("결제완료 하기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}

}
