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
			String sql = " select m.m_id, o.o_num, "
					+ " to_char(o.o_date,'YYYY-MM-DD'), "
					+ " m.m_zipCode, m.m_addr, m.m_addrDetail "
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
				vo.setO_date(rs.getString(3));
				vo.setM_zipCode(rs.getInt(4));
				vo.setM_addr(rs.getString(5));
				vo.setM_addrDetail(rs.getString(6));
				
								
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

}
