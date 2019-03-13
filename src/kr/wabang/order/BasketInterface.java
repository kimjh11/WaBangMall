package kr.wabang.order;

import java.util.List;

public interface BasketInterface {
	//장바구니 리스트 등록
	public int insertList (BasketVO vo);
	//장바구니 목록
	public List<BasketVO> selectList (String loginId);
	//장바구니 목록 한개 삭제
	public int deleteListOne(String loginId, String bCode);
	//장바구니 목록삭제
	public void deleteList(String bCode[], String loginId);
}
