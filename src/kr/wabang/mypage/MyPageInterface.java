package kr.wabang.mypage;

import java.util.List;

public interface MyPageInterface {

	//�ֹ���� �ҷ�����
	public List<OrderVO> getAllOrder(String userid);
	//���Ǹ�� �ҷ�����
	public List<DepositVO> getAllDeposit(String userid);

	//�ԱݿϷ�
	public int updateDeposit(String userid,String deposit,String i_code,String o_num);
}
