package kr.wabang.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandPayment implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//결제완료
		MyPageDAO dao = new MyPageDAO();
		OrderVO vo = new OrderVO();
		HttpSession session = req.getSession();
		
		String deposit = "결제완료";
		String i_code = req.getParameter("i_code");
		String o_num = req.getParameter("o_num");
		String userid = (String) session.getAttribute("loginId");
		
		//값들어왔는지 확인
		System.out.println("값들어왔는지 확인-------");
		System.out.println("로그인한 아이디="+userid);
		System.out.println("결제상태="+deposit);
		System.out.println("i_code="+i_code);
		System.out.println("o_num="+o_num);
		
		int cnt = dao.updateDeposit(userid, deposit, i_code,o_num);
		req.setAttribute("cnt", cnt);
		
		return "payment.jsp";
	}

}
