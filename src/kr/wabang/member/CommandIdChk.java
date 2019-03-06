package kr.wabang.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandIdChk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//아이디 중복 검사
		String userid = req.getParameter("userid");
		System.out.println("userid="+userid);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.idCheck(userid);
		
		//view 페이지에서 사용가능한 데이터가 된다.
		req.setAttribute("cnt", cnt);
		req.setAttribute("userid", userid);
		
		return "idChk.jsp";
	}

}
