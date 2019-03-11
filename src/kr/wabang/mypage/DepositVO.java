package kr.wabang.mypage;

public class DepositVO {
	private int q_num;
	private String m_id;
	private String q_title;
	private String q_content;
	private String q_regdate;
	
	//답변 날짜, 답변확인에 필요.
	private int a_num;
	private String a_regdate;
	
	//페이징 관련된 변수들
	private int num = 1; //현재 페이지
	private int totalRecord = 0; //총 레코드 수
	private int totalPage = 1; //총 페이지 수
	private int onePageRecord = 5; //1page에 표시할 레코드 수
	private int startPage = 1; //시작 페이지
	private int pageNumCount = 5; //한번에 출력할 페이지 번호 수
		 
	//
	public DepositVO() {
		
	}

	//
	public int getQ_num() {
		return q_num;
	}

	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public String getQ_regdate() {
		return q_regdate;
	}

	public void setQ_regdate(String q_regdate) {
		this.q_regdate = q_regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		if(num%pageNumCount == 0) { //5의 배수 일때
			startPage = (num/pageNumCount-1)*pageNumCount+1;
		}else{ //5의 배수가 아닐때
			startPage = (num/pageNumCount)*pageNumCount+1;
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//총 페이지수
		totalPage = (int)Math.ceil(totalRecord / (double)onePageRecord);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getOnePageRecord() {
		return onePageRecord;
	}

	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getPageNumCount() {
		return pageNumCount;
	}

	public void setPageNumCount(int pageNumCount) {
		this.pageNumCount = pageNumCount;
	}

	public int getA_num() {
		return a_num;
	}

	public void setA_num(int a_num) {
		this.a_num = a_num;
	}

	public String getA_regdate() {
		return a_regdate;
	}

	public void setA_regdate(String a_regdate) {
		this.a_regdate = a_regdate;
	}
	
	
}
