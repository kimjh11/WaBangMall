package kr.wabang.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.wabang.util.DBConnection;

public class ShoppingListDAO extends DBConnection implements ShoppingListInterface {

	@Override
	public List<ShoppingListVO> insertShoppingList(ShoppingListVO listVO) {
		List<ShoppingListVO> list = new ArrayList<ShoppingListVO>();
		// 장바구니 리스트추가
		try {
			dbCon();
			
			String bSelectOpt[] = listVO.getbSelectOpt();
			String bColor[] = listVO.getbColor();
			String bCount[] = listVO.getbCount();
			
			for(int i=0; i<bSelectOpt.length; i++) {
			   String sql = "insert into basket (i_code, m_id, b_count, b_selectOpt,"			   
					+ " b_selectColor, b_price, b_payment, b_regdate) values(?,?,?,?,?,?,?,sysdate)";
			   
			   	pstmt = con.prepareStatement(sql);
			
			   	pstmt.setString(1, listVO.getiCode());
				pstmt.setString(2, listVO.getmId());
				pstmt.setString(3, bCount[i]);
				pstmt.setString(4, bSelectOpt[i]);
				pstmt.setString(5, bColor[i]);
				pstmt.setInt(6, listVO.getbPrice());
				pstmt.setInt(7, listVO.getbPayment());

				pstmt.executeUpdate();
			}
			
			list.add(listVO);
			
		}catch(Exception e) {
			System.out.println("장바구니 리스트 추가 실패"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}
}
