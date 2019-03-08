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
		//�����Ϸ�
		MyPageDAO dao = new MyPageDAO();
		OrderVO vo = new OrderVO();
		HttpSession session = req.getSession();
		
		String deposit = "�����Ϸ�";
		String i_code = req.getParameter("i_code");
		String o_num = req.getParameter("o_num");
		String userid = (String) session.getAttribute("loginId");
		
		//�����Դ��� Ȯ��
		System.out.println("�����Դ��� Ȯ��-------");
		System.out.println("�α����� ���̵�="+userid);
		System.out.println("��������="+deposit);
		System.out.println("i_code="+i_code);
		System.out.println("o_num="+o_num);
		
		int cnt = dao.updateDeposit(userid, deposit, i_code,o_num);
		req.setAttribute("cnt", cnt);
		
		return "payment.jsp";
	}

}
