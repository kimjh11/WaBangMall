package kr.wabang.notice;

public class NoticeVO {
	private String adminId;
	private int n_num;
	private String n_title;
	private String n_content;
	private String n_regdate;
	
	//페이징 관련된 변수들
	private int num = 1; //현재 페이지
	private int totalRecord = 0; //총 레코드 수
	private int totalPage = 1; //총 페이지 수
	private int onePageRecord = 5; //1page에 표시할 레코드 수
	private int startPage = 1; //시작 페이지
	private int pageNumCount = 5; //한번에 출력할 페이지 번호 수
	
	//검색어
	private String searchWord = null;
	private String searchKey = null;
	
	//생성자
	public NoticeVO() {
		
	}
	
	//
	public NoticeVO(String adminId, int n_num, String n_title, String n_content, String n_regdate){
		this.adminId = adminId;
		this.n_num = n_num;
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_regdate = n_regdate;
	}

	//getter/setter
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public int getN_num() {
		return n_num;
	}
	public void setN_num(int n_num) {
		this.n_num = n_num;
	}

	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public String getN_regdate() {
		return n_regdate;
	}
	public void setN_regdate(String n_regdate) {
		this.n_regdate = n_regdate;
	}
	
	//페이징 , 검색어 관련 getter/setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		//현재 페이지 수 (num) / 한번에 출력할 페이지 번호 수 (pageNumCount)
		//      1  %  5  = 1
		//      2  %  5  = 2
		//      5  %  5  = 0
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

	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
