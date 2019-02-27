package kr.wabang.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/*.do")
public class ControllerAction extends HttpServlet {
	HashMap<String, CommandService> mapping = new HashMap<String, CommandService>();
	
    public ControllerAction() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		//properties�� UrlMapping.properties ������ �����ϱ�.
		String propertiesFilename = config.getInitParameter("proConfig");
		Properties pro = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propertiesFilename);
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("init�޼ҵ� - properties"+e.getMessage());
		}
		try {
			//properties�� �ִ� ���ڿ��� HashMap�� �����Ѵ�.
			Set keyList = pro.keySet();
			Iterator keyIterator = keyList.iterator();
			while(keyIterator.hasNext()) {//��ü�� �ִ��� ����� ��, key�� ������
				 String key = (String) keyIterator.next();
				 //              kr.goott.home.CommandIndex
				 String className = pro.getProperty(key); //�ش� key�� Ŭ������ �ش��ϴ� ���ڿ�
				 //���ڿ��� ��ü �����
				 Class commandClass = Class.forName(className);
				 //��ü�� ������ Ŭ������ CommandService�� ����ȯ�Ͽ� HashMap ����
				 CommandService command = (CommandService) commandClass.getDeclaredConstructors()[0].newInstance();
				 mapping.put(key, command);
				 
				 System.out.println("key="+key);
				 System.out.println("className="+className);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("HashMap���� ����"+e.getMessage());
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mvcStart(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mvcStart(request, response);
	}
	
	protected void mvcStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//�����ϸ�  /*.do, /index.do, /freeboard/list.do.....
		String uri = req.getRequestURI();                          
		System.out.println("uri="+uri); //  /webMVC/*.do
		
		String contextPath = req.getContextPath(); //  /webMVC
		System.out.println("contextPath="+contextPath);
		
		String commandKey = uri.substring(contextPath.length()); //  /*.do
		CommandService service = mapping.get(commandKey);
		String viewFile = service.process(req, res);
		
		//view ���Ϸ� ������ �̵�
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewFile);
		dispatcher.forward(req, res); // view�������� �̵��ϴ� ����.
	}
}
