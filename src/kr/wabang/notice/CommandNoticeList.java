package kr.wabang.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandNoticeList implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//공지사항 리스트 페이지
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();
		
		//현재 페이지
		String numStr = req.getParameter("num");
		if(numStr == null){
			vo.setNum(1);
		}else{
			vo.setNum(Integer.parseInt(numStr));
		}
		
		//검색어 ,키
		vo.setSearchWord(req.getParameter("searchWord"));
		if(vo.getSearchWord() == null || vo.getSearchWord().equals("")){
			vo.setSearchKey(null);
		}else{
			vo.setSearchKey(req.getParameter("searchKey"));
		}
		
		//총 레코드 수
		vo.setTotalRecord(dao.totalRecord(vo));
		
		//해당 페이지 레코드 리스트
		List<NoticeVO> list = dao.pageList(vo);
		
		req.setAttribute("vo", vo);
		req.setAttribute("list", list);
		
		return "notice.jsp";
	}
}
