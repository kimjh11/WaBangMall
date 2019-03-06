package kr.wabang.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandIdChk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//���̵� �ߺ� �˻�
		String userid = req.getParameter("userid");
		System.out.println("userid="+userid);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.idCheck(userid);
		
		//view ���������� ��밡���� �����Ͱ� �ȴ�.
		req.setAttribute("cnt", cnt);
		req.setAttribute("userid", userid);
		
		return "idChk.jsp";
	}

}
