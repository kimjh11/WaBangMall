package kr.wabang.order;

import java.util.List;

public interface ShoppingListInterface {
	//��ٱ��� ����Ʈ ���
	public List<ShoppingListVO> insertShoppingList (ShoppingListVO vo);
	//��ٱ��� ���
	public List<ShoppingListVO> selectShoppingList (String iCode);
}
