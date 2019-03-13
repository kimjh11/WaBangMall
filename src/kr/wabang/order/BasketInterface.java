package kr.wabang.order;

import java.util.List;

public interface BasketInterface {
	//��ٱ��� ����Ʈ ���
	public int insertList (BasketVO vo);
	//��ٱ��� ���
	public List<BasketVO> selectList (String loginId);
	//��ٱ��� ��� �Ѱ� ����
	public int deleteListOne(String loginId, String bCode);
	//��ٱ��� ��ϻ���
	public void deleteList(String bCode[], String loginId);
	//��������Ʈ ���
	public int insertOrderList(String userid);
	// �ֹ�����-ȸ�� Ż��
	public int orderDelete(String userid);
	// ��ٱ��� ��ü���� - ȸ��Ż��
	public int deleteListAll(String userid);
	
	
}
