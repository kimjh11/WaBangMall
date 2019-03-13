package kr.wabang.item;

import java.util.List;

public interface ItemInterface {
	//상품선택
	public void itemSelect(ItemVO vo);
	public List<ItemVO> selectItem();
	public ItemVO setVO();
}
