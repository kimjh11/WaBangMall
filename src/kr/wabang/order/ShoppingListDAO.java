package kr.wabang.order;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.mypage.OrderVO;
import kr.wabang.util.DBConnection;

public class ShoppingListDAO extends DBConnection implements ShoppingListInterface {

	@Override
	public int insertShoppingList(ShoppingListVO listVO) {
		List<ShoppingListVO> list = new ArrayList<ShoppingListVO>();
		int cnt = 0;
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

				cnt = pstmt.executeUpdate();
			}
			list.add(listVO);
			
		}catch(Exception e) {
			System.out.println("장바구니 리스트 추가 실패"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}

	
	
	@Override
	public List<ShoppingListVO> selectShoppingList(String loginId) {
		// 장바구니 목록확인
		List<ShoppingListVO> list = new ArrayList<ShoppingListVO>();
		try {
			dbCon();
			String sql = "select i.i_code, i.i_category, i.i_name, i.i_thumbnail,"
					+ " b.m_id, b.b_count, b.b_selectOpt, b.b_selectColor, b.b_price, b.b_payment, b.b_regdate"
					+ " from basket b join item i on b.i_code = i.i_code where b.m_id = ? order by rownum desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ShoppingListVO vo = new ShoppingListVO();
				vo.setiCode(rs.getString(1));
				vo.setiCategory(rs.getString(2));
				vo.setiName(rs.getString(3));
				vo.setiThumbnail(rs.getString(4));
				vo.setmId(rs.getString(5));
				vo.setbCountStr(rs.getString(6));
				vo.setbSelectOptStr(rs.getString(7));
				vo.setbColorStr(rs.getString(8));
				vo.setbPrice(rs.getInt(9));
				vo.setbPayment(rs.getInt(10));
				vo.setbRegdate(rs.getString(11));
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

	//장바구니삭제
	public int deleteShoppingList(String userid) {
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



	@Override
	public List<OrderListVO> selectOrderList(String userid) {
		List<OrderListVO> list = new ArrayList<OrderListVO>();
		try {
			dbCon();
			String sql = "select i.i_code, i.i_category, i.i_name, i.i_thumbnail,"
							+ " o.o_selectOpt, o.o_selectColor, o.o_count, o.o_payment "
							+ " from item i join orderList o "
							+ " on i.i_code = o.i_code "
							+ " where m_id=? order by rownum desc ";
						
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderListVO vo = new OrderListVO();
				vo.setI_code(rs.getString(1));
				vo.setI_category(rs.getString(2));
				vo.setI_name(rs.getString(3));
				vo.setI_thumbnail(rs.getString(4));
				vo.setO_selectOpt(rs.getString(5));
				vo.setO_selectColor(rs.getString(6));
				vo.setO_count(rs.getString(7));
				vo.setO_payment(rs.getInt(8));
					
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("주문 목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}
	
}
