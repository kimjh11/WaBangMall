package kr.wabang.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandNoticeWrite implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//공지사항 등록하기
		req.setCharacterEncoding("UTF-8");
		
		NoticeVO vo = new NoticeVO();
		vo.setAdminId(req.getParameter("adminid"));
		vo.setN_title(req.getParameter("title"));
		vo.setN_content(req.getParameter("content"));
		
		System.out.println("adminid=" +req.getParameter("adminid"));
		System.out.println("title=" +req.getParameter("title"));
		System.out.println("content=" +req.getParameter("content"));
		
		NoticeDAO dao = new NoticeDAO();
		int cnt = dao.NoticeInsert(vo);
		
		req.setAttribute("cnt", cnt);
		
		return "noticeWriteOk.jsp";
	}

}
