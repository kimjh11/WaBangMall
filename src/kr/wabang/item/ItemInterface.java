package kr.wabang.item;

import java.util.List;

public interface ItemInterface {
	//��ǰ����
	public void itemSelect(ItemVO vo);
	public List<ItemVO> selectItem();
	public ItemVO setVO();
}
