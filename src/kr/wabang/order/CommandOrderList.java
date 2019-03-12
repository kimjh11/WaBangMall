package kr.wabang.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;


public class CommandOrderList implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//주문확인페이지
		HttpSession ses = req.getSession();
		String userid = (String)ses.getAttribute("loginId");
		
		ShoppingListDAO dao = new ShoppingListDAO();
		System.out.println("아이디:"+userid);
		
		int cnt = dao.insertOrderList(userid);
		System.out.println("cnt:"+cnt);
		
		System.out.println("주문리스트 cnt:"+cnt);
		int cnt2 = dao.deleteShoppingList(userid);
		System.out.println("장바구니리스트 삭제 cnt:"+cnt2);
	
		List<OrderListVO> list = dao.selectOrderList(userid);
		req.setAttribute("list", list);
			
		
		
		
		return "storeOrderList.jsp";
	}

}
