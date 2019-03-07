package kr.wabang.item;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CmdDetailView implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 상품 상세페이지
		String iCode = req.getParameter("i-code");

		ItemDAO dao = new ItemDAO();
		List<ItemVO> list = dao.itemSelect(iCode);
		
		req.setAttribute("list", list);
		
		return "detailView.jsp";
	}

}
