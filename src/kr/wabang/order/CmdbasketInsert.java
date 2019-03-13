package kr.wabang.order;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;
import kr.wabang.item.ItemDAO;
import kr.wabang.item.ItemVO;

public class CmdbasketInsert implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ��ٱ���������
		req.setCharacterEncoding("UTF-8");

		
		String bSelectOpt[] = req.getParameterValues("bSelectOpt");
		String bColor[] = req.getParameterValues("bColor");		
		String bCount[] = req.getParameterValues("bCount");
		
		//System.out.println("�ɼǸ�:"+Arrays.deepToString(bSelectOpt));
		//System.out.println("�����:"+Arrays.deepToString(bColor));
		//System.out.println("����:"+Arrays.deepToString(bCount));
		
		ItemVO itemVO = new ItemVO(req.getParameter("iCode"));
		ItemDAO itemDAO = new ItemDAO();
		
		itemDAO.itemSelect(itemVO);
		itemVO.setNoOptPrice(itemVO.getiPrice(), itemVO.getiDiscount());//����
		
		HttpSession ses = req.getSession();

		BasketVO listVO = new BasketVO();
		BasketDAO dao = new BasketDAO();
		
		listVO.setiCode(req.getParameter("iCode"));
		listVO.setmId((String)ses.getAttribute("loginId"));
		listVO.setbCount(bCount);
		listVO.setbSelectOpt(bSelectOpt);
		listVO.setbColor(bColor);
		listVO.setbPrice(itemVO.getNoOptPrice());//��ǰ����
		listVO.setbPayment(Integer.parseInt(req.getParameter("bPayment")));//�Ѱ����ݾ�
		
		int cnt = dao.insertList(listVO);
		
		req.setAttribute("cnt", cnt);

		//mvc���Ͽ��� view���ϸ��� ��������������� ajaxȣ�� �� ��������� ����
		//������ �����߻�
		return "basketInsertOk.jsp";
	}

}
