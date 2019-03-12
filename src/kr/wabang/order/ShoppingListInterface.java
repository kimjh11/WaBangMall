package kr.wabang.order;

import java.util.List;

public interface ShoppingListInterface {
	//장바구니 리스트 등록
	public List<ShoppingListVO> insertShoppingList (ShoppingListVO vo);
	//장바구니 목록
	public List<ShoppingListVO> selectShoppingList (String iCode);
}
