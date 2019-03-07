package kr.wabang.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;
import kr.wabang.member.MemberDAO;
import kr.wabang.member.MemberVO;

public class CommandMyPageUpdate implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//수정하기
		req.setCharacterEncoding("UTF-8");
		
		MemberVO vo = new MemberVO();
		vo.setM_id(req.getParameter("userid"));
		vo.setM_pwd(req.getParameter("userpwd"));
		vo.setM_name(req.getParameter("username"));
		vo.setM_tel(req.getParameter("tel1")+"-"+req.getParameter("tel2")+"-"+req.getParameter("tel3"));
		vo.setM_email(req.getParameter("email1")+"@"+req.getParameter("email2"));
		vo.setM_zipCode(req.getParameter("postcode"));
		vo.setM_addr(req.getParameter("address"));
		vo.setM_addrDetail(req.getParameter("detailAddress"));
		vo.setM_addrReference(req.getParameter("extraAddress"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.myInfoUpdate(vo);
		
		req.setAttribute("cnt", cnt);
		
		return "myInfoOk.jsp";
	}

}
