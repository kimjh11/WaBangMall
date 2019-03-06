package kr.wabang.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandLoginOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//�α���
		MemberVO vo = new MemberVO();
		vo.setM_id(req.getParameter("userid"));
		vo.setM_pwd(req.getParameter("userpwd"));
		
		MemberDAO dao = new MemberDAO();
		dao.loginCheck(vo);
		
		req.setAttribute("vo", vo);
		
		//�α��� ������ ���ǿ� �ʿ��� ������ ��� 
		if(vo.getLoginStatus().equals("Y")){
			HttpSession session = req.getSession();
			session.setAttribute("loginId", vo.getM_id());
			System.out.println(vo.getM_id());
			session.setAttribute("loginStatus", vo.getLoginStatus());
			System.out.println(vo.getLoginStatus());
		}
		
		return "loginOk.jsp";
	}

}
