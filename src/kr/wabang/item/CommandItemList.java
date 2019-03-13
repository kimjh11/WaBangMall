package kr.wabang.item;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandItemList implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 상품목록들을 가져오는 곳
		ItemDAO dao = new ItemDAO();
		ItemVO vo = dao.setVO();
		List<ItemVO> list = dao.selectItem();
		 
		req.setAttribute("list", list);
		return "itemList.jsp";
	}

}
