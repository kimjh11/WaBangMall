package kr.wabang.order;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class BasketDAO extends DBConnection implements BasketInterface {

	@Override
	public int insertList(BasketVO listVO) {
		List<BasketVO> list = new ArrayList<BasketVO>();
		int cnt = 0;
		// 장바구니 리스트추가
		try {
			dbCon();
			
			String bSelectOpt[] = listVO.getbSelectOpt();
			String bColor[] = listVO.getbColor();
			String bCount[] = listVO.getbCount();
			
			for(int i=0; i<bSelectOpt.length; i++) {
			   String sql = "insert into basket (b_code, i_code, m_id, b_count, b_selectOpt,"			   
					+ " b_selectColor, b_price, b_payment, b_regdate) values(basketSq.nextVal,?,?,?,?,?,?,?,sysdate)";
			   
			   	pstmt = con.prepareStatement(sql);
			
			   	pstmt.setString(1, listVO.getiCode());
				pstmt.setString(2, listVO.getmId());
				pstmt.setString(3, bCount[i]);
				pstmt.setString(4, bSelectOpt[i]);
				pstmt.setString(5, bColor[i]);
				pstmt.setInt(6, listVO.getbPrice());
				pstmt.setInt(7, listVO.getbPayment());

				cnt = pstmt.executeUpdate();
			}
			list.add(listVO);
			
		}catch(Exception e) {
			System.out.println("장바구니 리스트 추가 실패"+e.getMessage());
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}

	
	
	@Override
	public List<BasketVO> selectList(String loginId) {
		// 장바구니 목록확인
		List<BasketVO> list = new ArrayList<BasketVO>();
		try {
			dbCon();
			String sql = "select i.i_code, i.i_category, i.i_name, i.i_thumbnail,"
					+ " b.b_code, b.m_id, b.b_count, b.b_selectOpt, b.b_selectColor, b.b_price, b.b_payment, b.b_regdate"
					+ " from basket b join item i on b.i_code = i.i_code where b.m_id = ? order by b.b_regdate desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BasketVO vo = new BasketVO();
				vo.setiCode(rs.getString(1));
				vo.setiCategory(rs.getString(2));
				vo.setiName(rs.getString(3));
				vo.setiThumbnail(rs.getString(4));
				vo.setbCode(rs.getInt(5));
				vo.setmId(rs.getString(6));
				vo.setbCountStr(rs.getString(7));
				vo.setbSelectOptStr(rs.getString(8));
				vo.setbColorStr(rs.getString(9));
				vo.setbPrice(rs.getInt(10));
				vo.setbPayment(rs.getInt(11));
				vo.setbRegdate(rs.getString(12));
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("장바구니 목록 불러오기 에러"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public int insertOrderList(String userid) {
		int cnt = 0;
		try {
			dbCon();
			String sql = " insert into orderList (o_num,i_code, m_id, o_count, o_selectOpt,o_selectColor, "
					+ " o_price,o_payment,o_deposit,o_date, o_delivery) " 
					+ " select ?||to_char(b_regdate,'YYYYMMDDhh24mi'), "
					+ " i_code, m_id, b_count,b_selectopt,b_selectColor, "
					+ " b_price, b_payment, '미결제', sysdate, '배송준비중' "
					+ " from basket where m_id= ? ";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userid);
			pstmt.setString(2,userid);
			
			cnt= pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("주문등록 오류..."+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	@Override
	public int orderDelete(String userid) {
		// 주문삭제-회원 탈퇴
		int orderCnt = 0;
		try{
			dbCon();
			String sql = "delete from orderList where m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			orderCnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("장바구니 삭제-회원 탈퇴 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return orderCnt;
	}


	@Override
	public int deleteListOne(String loginId, String bCode) {
		// 장바구니 목록 한개 삭제
		int cnt = 0;
		return cnt;
	}



	@Override
	public void deleteList(String[] bCode, String loginId) {
		// 장바구니 목록 삭제
		int cnt=0;
		try {
			dbCon();
			for(int i=0; i<bCode.length; i++) {
				String sql = "delete from basket where b_code=? and m_id=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, bCode[i]);
				pstmt.setString(2, loginId);
				
				cnt = pstmt.executeUpdate();
			}
		}catch(Exception e) {
			System.out.println("장바구니 목록 삭제 에러"+e.getMessage());
		}finally {
			dbClose();
		}
	}


	//장바구니삭제
		public int deleteListAll(String userid) {
			int cnt = 0;
			try {
			dbCon();
			String sql = " delete from basket "
					+ " where m_id=? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			cnt = pstmt.executeUpdate();
			
			}catch(Exception e){
				System.out.println("장바구니삭제 에러..."+e.getMessage());
			}finally {
				dbClose();
			}
			return cnt;
		}


}
