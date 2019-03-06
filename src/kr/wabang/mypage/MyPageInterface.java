package kr.wabang.mypage;

import java.util.List;

public interface MyPageInterface {

	//주문목록 불러오기
	public List<OrderVO> getAllOrder(String userid);
	//문의목록 불러오기
	public List<DepositVO> getAllDeposit(String userid);
	//
}
