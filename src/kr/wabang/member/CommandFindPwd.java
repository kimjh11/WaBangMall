package kr.wabang.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandFindPwd implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String userid = req.getParameter("userid");
		String email = req.getParameter("email2");
		System.out.println("비번찾기 아이디:"+userid);
		System.out.println("비번찾기 이메일:"+email);
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.findPwd(userid, email);
		
		req.setAttribute("pwd", vo.getM_pwd());
		System.out.println("pwd:"+vo.getM_pwd());;
		
		return "find.jsp";
	}

}
