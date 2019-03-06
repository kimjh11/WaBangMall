package kr.wabang.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandMyInfoUpdate implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//수정하기
		req.setCharacterEncoding("UTF-8");
		
		MemberVO vo = new MemberVO();
		vo.setM_name(req.getParameter("username"));
		vo.setM_zipCode(req.getParameter("postcode"));
		vo.setM_addr(req.getParameter("address"));
		vo.setM_addrDetail(req.getParameter("detailAddress"));
		vo.setM_addrReference(req.getParameter("extraAddress"));
		vo.setM_tel(req.getParameter("tel1")+"-"+req.getParameter("tel2")+"-"+req.getParameter("tel3"));
		vo.setM_email(req.getParameter("email1")+"@"+req.getParameter("email2"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.myInfoUpdate(vo);
		
		req.setAttribute("cnt", cnt);
		
		return "myInfoOk.jsp";
	}

}
