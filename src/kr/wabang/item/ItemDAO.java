package kr.wabang.item;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class ItemDAO extends DBConnection implements ItemInterface {

	@Override
	public List<ItemVO> itemSelect(String iCode) {
		//상품선택
		List<ItemVO> list = new ArrayList<ItemVO>();
		
		try {
			dbCon();
			String sql = "select i_code, i_category, i_name, i_price,"
					+ " i_discount, i_thumbnail, i_opt, i_color, i_detail,"
					+ " to_char(i_regdate,'YYYY-MM-DD')"
					+ " from item where i_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, iCode);
			rs = pstmt.executeQuery();
			
			
			
			if(rs.next()) {
				ItemVO vo = new ItemVO();
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
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("상품 선택 에러"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

}
