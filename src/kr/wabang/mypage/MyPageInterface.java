package kr.wabang.mypage;

import java.util.List;

public interface MyPageInterface {

	//�ֹ���� �ҷ�����
	public List<OrderVO> getAllOrder(String userid);
	//���Ǹ�� �ҷ�����
	public List<DepositVO> getAllDeposit(String userid);
	//
}
