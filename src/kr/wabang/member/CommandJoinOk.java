package kr.wabang.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandJoinOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//회원가입
		req.setCharacterEncoding("UTF-8");
		
		MemberVO vo = new MemberVO();
		vo.setM_id(req.getParameter("userid"));
		vo.setM_pwd(req.getParameter("userpwd1"));
		vo.setM_name(req.getParameter("username"));
		
		vo.setM_tel(req.getParameter("tel1")+"-"+req.getParameter("tel2")+"-"+req.getParameter("tel3"));
		vo.setM_email(req.getParameter("email1")+"@"+req.getParameter("email2"));
		
		vo.setM_zipCode(req.getParameter("postcode"));
		vo.setM_addr(req.getParameter("address"));
		vo.setM_addrDetail(req.getParameter("detailAddress"));
		vo.setM_addrReference(req.getParameter("extraAddress"));
		
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		
		req.setAttribute("cnt", cnt);
		
		return "insertResult.jsp";
	}

}
