package kr.wabang.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandOrderListOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession ses = req.getSession();
		String loginId = (String)ses.getAttribute("loginId");
		BasketDAO dao = new BasketDAO();
		
		int inCnt = dao.insertOrderList(loginId);
		System.out.println("주문리스트 등록 inCnt:"+inCnt);
		int delCnt = dao.deleteListAll(loginId);
		System.out.println("장바구니 모두삭제 delCnt:"+delCnt);
		
		req.setAttribute("inCnt", inCnt);
		
		return "storeOrderListOk.jsp";
	}

}
