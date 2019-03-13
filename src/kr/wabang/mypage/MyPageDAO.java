package kr.wabang.mypage;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class MyPageDAO extends DBConnection implements MyPageInterface {
	
	@Override
	public int totalRecord(OrderVO vo,String userid) {
		//총 레코드 수
				int totalRecord = 0;
				try{
					dbCon();
					String sql = "select count(o_num) from orderList where m_id = ?  ";
		
					System.out.println(sql);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,userid);
					rs = pstmt.executeQuery();
					if(rs.next()){
						totalRecord = Integer.parseInt(rs.getString(1));
					}
				}catch(Exception e){
					System.out.println("총 레코드수 에러"+e.getMessage());
				}finally{
					dbClose();
				}
				return totalRecord;
	}

	@Override
	public int totalRecordMyDeposit(DepositVO vo, String userid) {
		// 총 레코드 수 - 내문의
		int totalRecord = 0;
		try{
			dbCon();
			String sql = "select count(q_num) from question where m_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				//totalRecord = Integer.parseInt(rs.getString(1));
				totalRecord = rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println("총 레코드 수 내문의"+e.getMessage());
		}finally{
			dbClose();
		}
		return totalRecord;
	}
	
	//주문목록
	public List<OrderVO> getAllOrder(String userid,OrderVO vo) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			dbCon();
			String sql = "select * from (select * from "
						+ "(select m.m_id, o.o_num, o.i_code,o.o_selectOpt,o.o_selectColor,o.o_count, o.o_payment, "
							+ " to_char(o.o_date,'YYYY-MM-DD') e, "
							+ " m.m_zipCode, m.m_addr, m.m_addrDetail,"
							+ "	o.o_deposit, o.o_delivery "
							+ " from member m join orderList o "
							+ " on m.m_id=o.m_id "
							+ " where m.m_id=? order by o.o_date desc)"
						+" where rownum <= ? order by e asc) "
					+" where rownum <= ? order by e desc ";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			pstmt.setInt(2, vo.getNum()*vo.getOnePageRecord());
			
			int lastPageRecord = vo.getTotalRecord()%vo.getOnePageRecord();
			
			if(vo.getNum() == vo.getTotalPage()){
				// 1,2,3,4,0
				pstmt.setInt(3, lastPageRecord);
				System.out.println("lastPageRecord="+lastPageRecord);
			}else{
				// 5,5,5,5....
				pstmt.setInt(3, vo.getOnePageRecord());
				System.out.println("vo.getOnePageRecord()="+vo.getOnePageRecord());
			}
			
			if(vo.getNum() == vo.getTotalPage() && lastPageRecord == 0){
				pstmt.setInt(3, vo.getOnePageRecord());
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO vo1 = new OrderVO();
				vo1.setM_id(rs.getString(1));
				vo1.setO_num(rs.getString(2));
				vo1.setI_code(rs.getString(3));
				vo1.setO_selectOpt(rs.getString(4));
				vo1.setO_selectColor(rs.getString(5));
				vo1.setO_count(rs.getInt(6));
				vo1.setO_payment(rs.getInt(7));
				vo1.setO_date(rs.getString(8));
				vo1.setM_zipCode(rs.getInt(9));
				vo1.setM_addr(rs.getString(10));
				vo1.setM_addrDetail(rs.getString(11));
				vo1.setO_deposit(rs.getString(12));
				vo1.setO_delivery(rs.getString(13));
							
				list.add(vo1);
			}
			
		}catch(Exception e){
			System.out.println("주문 목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	//문의목록
	public List<DepositVO> getAllDeposit(String userid, DepositVO vo) {
		List<DepositVO> list = new ArrayList<DepositVO>();
		try {
			dbCon();
			String sql = "select * from "
					+	" (select qq, mm, q_title, q_content, e, aq, e1 from " 
					+	" (select q.q_num qq, m.m_id mm, q_title, q_content, to_char(q.q_regdate,'YY-MM-DD') e, a.q_num aq, to_char(a.a_regdate,'YY-MM-DD HH:mm:ss') e1 "   
					+	" from question q join member m " 
					+	" on m.m_id = q.m_id "
					+	" full outer join answer a "
					+	" on a.q_num = q.q_num "
					+	" where q.m_id= ?"  
					+	" order by q.q_regdate desc) " 
					+	" where rownum <= ? order by qq asc) " 
					+	" where rownum <= ? order by qq desc ";
			pstmt = con.prepareStatement(sql);
			System.out.println("문의목록="+sql);
			
			pstmt.setString(1, userid);
			
			pstmt.setInt(2, vo.getNum()*vo.getOnePageRecord());
			System.out.println("**="+vo.getNum()*vo.getOnePageRecord());
			
			int lastPageRecord = vo.getTotalRecord()%vo.getOnePageRecord();
			
			if(vo.getNum() == vo.getTotalPage()){
				// 1,2,3,4,0
				pstmt.setInt(3, lastPageRecord);
				System.out.println("lastPageRecord="+lastPageRecord);
			}else{
				// 5,5,5,5....
				pstmt.setInt(3, vo.getOnePageRecord());
				System.out.println("vo.getOnePageRecord()="+vo.getOnePageRecord());
			}
			
			if(vo.getNum() == vo.getTotalPage() && lastPageRecord == 0){
				pstmt.setInt(3, vo.getOnePageRecord());
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DepositVO vo1 = new DepositVO();
				vo1.setQ_num(rs.getInt(1));
				vo1.setM_id(rs.getString(2));
				vo1.setQ_title(rs.getString(3));
				vo1.setQ_content(rs.getString(4));
				vo1.setQ_regdate(rs.getString(5));
				vo1.setA_num(rs.getInt(6));
				vo1.setA_regdate(rs.getString(7));
				list.add(vo1);
			}
			
		}catch(Exception e){
			System.out.println("질문 목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	//결제완료
	public int updateDeposit(String userid,String deposit, String i_code,String o_num) {
		int cnt = 0;
		try {
		dbCon();
		String sql = " update orderList set o_deposit = ?, o_fix = sysdate "
				+ " where m_id=? and i_code=? and o_num= ?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, deposit);
		pstmt.setString(2, userid);
		pstmt.setString(3, i_code);
		pstmt.setString(4, o_num);
		pstmt.executeUpdate();
		cnt = pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("결제완료 하기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	@Override
	public int orderDelete(String id, String num, String itemNum, String opt) {
		int cnt = 0;
		try {
		dbCon();
		String sql = " delete from orderList "
				+ " where m_id=? and i_code=? and o_num= ? and o_selectopt=? ";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, itemNum);
		pstmt.setString(3, num);
		pstmt.setString(4, opt);
		cnt = pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("주문취소 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}
}
