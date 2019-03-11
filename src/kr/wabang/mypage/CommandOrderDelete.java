package kr.wabang.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandOrderDelete implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//
		MyPageDAO dao = new MyPageDAO();
		
		String id = req.getParameter("m_id");
		String num = req.getParameter("o_num");
		String itemNum = req.getParameter("i_code");
		String opt = req.getParameter("o_selectOpt");
		System.out.println("아이디:"+id+"주문번호:"+num+"상품번호:"+itemNum+"옵션:"+opt);
		
		int cnt = dao.orderDelete(id, num, itemNum, opt);
		req.setAttribute("cnt", cnt);
		
		return "orderDelete.jsp";
	}

}
