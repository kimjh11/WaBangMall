package kr.wabang.order;

import java.util.List;

public interface ShoppingListInterface {
	//��ٱ��� ����Ʈ ���
	public int insertShoppingList (ShoppingListVO vo);
	//��ٱ��� ���
	public List<ShoppingListVO> selectShoppingList (String userid);
	//�ֹ� ��� ���
	public int insertOrderList (String userid);
	//��ٱ��� ����
	public int deleteShoppingList (String userid);
	//�ֹ� ���
	public List<OrderListVO> selectOrderList (String userid);
	
	//�ֹ� ����-ȸ�� Ż��
	public int orderDelete(String userid);
}
