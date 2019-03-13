package kr.wabang.order;

import java.util.List;

public interface ShoppingListInterface {
	//장바구니 리스트 등록
	public int insertShoppingList (ShoppingListVO vo);
	//장바구니 목록
	public List<ShoppingListVO> selectShoppingList (String userid);
	//주문 목록 등록
	public int insertOrderList (String userid);
	//장바구니 삭제
	public int deleteShoppingList (String userid);
	//주문 목록
	public List<OrderListVO> selectOrderList (String userid);
	
	//주문 삭제-회원 탈퇴
	public int orderDelete(String userid);
}
