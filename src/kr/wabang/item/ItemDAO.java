package kr.wabang.item;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class ItemDAO extends DBConnection implements ItemInterface{

	@Override
	public List<ItemVO> selectItem() {
		// DB에 있는 데이텉 뺴오기
		List<ItemVO> list = new ArrayList<ItemVO>();
		try {
			dbCon();
			String sql = "select i_code, i_name, i_price, i_discount, to_char(i_regdate, 'YY-DD-MM'), i_thumbnail, i_category from item";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemVO vo = new ItemVO();
				vo.setCode(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setDiscount(rs.getInt(4));
				vo.setRegdate(rs.getString(5));
				vo.setCategory(rs.getString(7));
				
				String thum = rs.getString(6).substring(0,rs.getString(6).indexOf("|"));
				vo.setThumbnail(thum);
				int disprice = rs.getInt(3)-((rs.getInt(3)*rs.getInt(4))/100);
				System.out.println(disprice);
				vo.setDisprice(disprice);
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("아이템 뺴오기 실패"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public ItemVO setVO() {
		ItemVO vo = new ItemVO();
		try {
			dbCon();
			String sql = "select i_thumbnail from item";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setThumbnail(rs.getString(1));
				
			}
		}catch(Exception e) {
			System.out.println("아이템 뺴오기 실패"+e.getMessage());
		}finally {
			dbClose();
		}
		return vo;
	}
	
}
