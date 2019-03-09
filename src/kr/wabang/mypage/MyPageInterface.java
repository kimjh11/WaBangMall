package kr.wabang.mypage;

import java.util.List;

import kr.wabang.notice.NoticeVO;

public interface MyPageInterface {

	//주문목록 불러오기
	public List<OrderVO> getAllOrder(String userid,OrderVO vo);
	//문의목록 불러오기
	public List<DepositVO> getAllDeposit(String userid);

	//입금완료
	public int updateDeposit(String userid,String deposit,String i_code,String o_num);

	//총  레코드 수
	public int totalRecord(OrderVO vo,String userid);
		
}
