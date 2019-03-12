package kr.wabang.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CmdShoppingList implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 장바구니보기
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("iCode="+req.getParameter("iCode"));
		System.out.println("bSelectOpt="+req.getParameter("bSelectOpt"));
		
		
		
		return "shoppingList.jsp";
	}

}
