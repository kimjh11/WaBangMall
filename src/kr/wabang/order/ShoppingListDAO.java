package kr.wabang.order;

import kr.wabang.util.DBConnection;

public class ShoppingListDAO extends DBConnection implements ShoppingListInterface {

	@Override
	public int insertShoppingList(ShoppingListVO vo) {
		// ��ٱ��� ����Ʈ�߰�
		int cnt = 0;
		try {
			dbCon();
			String sql = "insert into basket (i_code, m_id, b_count, b_selectOpt,"
					+ " b_selectColor, b_price, b_payment, b_regdate) values(?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getiCode());
			pstmt.setString(2, vo.getmId());
			
		}catch(Exception e) {
			System.out.println("��ٱ��� ����Ʈ �߰� ����"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}

}
