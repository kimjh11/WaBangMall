package kr.wabang.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandMyDeposit implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//�� ���� ���
		MyPageDAO dao = new MyPageDAO();
		
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("loginId");
		
		//���̵� �޾ƿԴ��� Ȯ��.
		System.out.println("�α����� ���̵�="+userid);
		
		List<DepositVO> list = dao.getAllDeposit(userid);
		req.setAttribute("list", list);
		
		return "mydeposit.jsp";
	}

}
