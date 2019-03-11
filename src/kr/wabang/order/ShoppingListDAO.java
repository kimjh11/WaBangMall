package kr.wabang.order;

import kr.wabang.util.DBConnection;

public class ShoppingListDAO extends DBConnection implements ShoppingListInterface {

	@Override
	public int insertShoppingList(ShoppingListVO vo) {
		
		// 장바구니 리스트추가
		int cnt = 0;
		try {
			dbCon();
			String sql = "insert into basket (i_code, m_id, b_count, b_selectOpt,"
					+ " b_selectColor, b_price, b_payment, b_regdate) values(?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getiCode());
			pstmt.setString(2, vo.getmId());
			pstmt.setString(3, vo.getbCount());
			pstmt.setString(4, vo.getbSelectOpt());
			pstmt.setString(5, vo.getbColor());
			pstmt.setInt(6, vo.getbPrice());
			pstmt.setInt(7, vo.getbPayment());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("장바구니 리스트 추가 실패"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}
}
