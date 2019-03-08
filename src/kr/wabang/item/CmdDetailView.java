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
		ItemVO vo = new ItemVO(req.getParameter("i-code"));
		ItemDAO dao = new ItemDAO();

		dao.itemSelect(vo);
		vo.setNoOptPrice(vo.getiPrice(), vo.getiDiscount());
		System.out.println(vo.getNoOptPrice());
		req.setAttribute("vo", vo);
		
		return "detailView.jsp";
	}

}
