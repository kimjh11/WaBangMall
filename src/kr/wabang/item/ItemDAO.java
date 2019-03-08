package kr.wabang.item;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class ItemDAO extends DBConnection implements ItemInterface {

	@Override
	public void itemSelect(ItemVO vo) {
		//상품선택
		try {
			dbCon();
			String sql = "select i_code, i_category, i_name, i_price,"
					+ " i_discount, i_thumbnail, i_opt, i_color, i_detail,"
					+ " to_char(i_regdate,'YYYY-MM-DD')"
					+ " from item where i_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getiCode());
			rs = pstmt.executeQuery();

			if(rs.next()) {
				vo.setiCode(rs.getString(1));
				vo.setiCategoryStr(rs.getString(2));
				vo.setiName(rs.getString(3));
				vo.setiPrice(rs.getInt(4));
				vo.setiDiscount(rs.getInt(5));
				vo.setiThumbnailStr(rs.getString(6));
				vo.setiOptStr(rs.getString(7));
				vo.setiColorStr(rs.getString(8));
				vo.setiDetail(rs.getString(9));
				vo.setiRegdate(rs.getString(10));
				
				System.out.println(vo.toString());
			}
		}catch(Exception e) {
			System.out.println("상품 선택 에러"+e.getMessage());
		}finally {
			dbClose();
		}
	}

}
