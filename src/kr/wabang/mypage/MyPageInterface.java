package kr.wabang.mypage;

import java.util.List;

import kr.wabang.notice.NoticeVO;

public interface MyPageInterface {

	//�ֹ���� �ҷ�����
	public List<OrderVO> getAllOrder(String userid,OrderVO vo);
	//���Ǹ�� �ҷ�����
	public List<DepositVO> getAllDeposit(String userid);

	//�ԱݿϷ�
	public int updateDeposit(String userid,String deposit,String i_code,String o_num);

	//��  ���ڵ� ��
	public int totalRecord(OrderVO vo,String userid);
		
}
