package kr.wabang.notice;

public class NoticeVO {
	private String adminId;
	private int n_num;
	private String n_title;
	private String n_content;
	private String n_regdate;
	
	//����¡ ���õ� ������
	private int num = 1; //���� ������
	private int totalRecord = 0; //�� ���ڵ� ��
	private int totalPage = 1; //�� ������ ��
	private int onePageRecord = 5; //1page�� ǥ���� ���ڵ� ��
	private int startPage = 1; //���� ������
	private int pageNumCount = 5; //�ѹ��� ����� ������ ��ȣ ��
	
	//�˻���
	private String searchWord = null;
	private String searchKey = null;
	
	//������
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
	
	//����¡ , �˻��� ���� getter/setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		//���� ������ �� (num) / �ѹ��� ����� ������ ��ȣ �� (pageNumCount)
		//      1  %  5  = 1
		//      2  %  5  = 2
		//      5  %  5  = 0
		if(num%pageNumCount == 0) { //5�� ��� �϶�
			startPage = (num/pageNumCount-1)*pageNumCount+1;
		}else{ //5�� ����� �ƴҶ�
			startPage = (num/pageNumCount)*pageNumCount+1;
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//�� ��������
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
