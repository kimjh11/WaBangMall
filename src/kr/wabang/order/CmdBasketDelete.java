package kr.wabang.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CmdBasketDelete implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 장바구니 목록 삭제
		req.setCharacterEncoding("UTF-8");
		System.out.println(req.getParameter("check"));
		String bCode[] = req.getParameterValues("check");

		for(int i=0; i<bCode.length; i++) {
			System.out.println(bCode[i]);
		}
		HttpSession ses = req.getSession();
		String loginId = (String)ses.getAttribute("loginId") ;
		
		BasketDAO dao = new BasketDAO();
		dao.deleteList(bCode, loginId);
		
		return "baskcetDeleteOk.jsp";
	}

}
