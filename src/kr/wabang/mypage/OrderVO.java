package kr.wabang.mypage;

public class OrderVO {
	private String m_id;
	private String o_num;
	private String i_code;
	private int o_count;
	private String o_selectOpt;
	private String o_selectColor;
	private int i_price;
	private int o_price;
	private int o_payment;
	private String o_deposit;
	private String o_date;
	private String o_fix;
	private String o_delivery;
	private String o_deliverydate;
		
		//회원주소
		private int m_zipCode;
		private String m_addr;
		private String m_addrDetail;
		//페이징
		private int num = 1; //현재 페이지
		private int totalRecord = 0; //총 레코드 수
		private int totalPage = 1; //총 페이지 수
		private int onePageRecord = 5; //1page에 표시할 레코드 수
		private int startPage = 1; //시작 페이지
		private int pageNumCount = 5; //한번에 출력할 페이지 번호 수
		
	public OrderVO() {}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getO_num() {
		return o_num;
	}

	public void setO_num(String o_num) {
		this.o_num = o_num;
	}

	public String getI_code() {
		return i_code;
	}

	public void setI_code(String i_code) {
		this.i_code = i_code;
	}

	public int getO_count() {
		return o_count;
	}

	public void setO_count(int o_count) {
		this.o_count = o_count;
	}

	public String getO_selectOpt() {
		return o_selectOpt;
	}

	public void setO_selectOpt(String o_selectOpt) {
		this.o_selectOpt = o_selectOpt;
	}

	public int getI_price() {
		return i_price;
	}

	public void setI_price(int i_price) {
		this.i_price = i_price;
	}

	public int getO_price() {
		return o_price;
	}

	public void setO_price(int o_price) {
		this.o_price = o_price;
	}

	public int getO_payment() {
		return o_payment;
	}

	public void setO_payment(int o_payment) {
		this.o_payment = o_payment;
	}

	public String getO_deposit() {
		return o_deposit;
	}

	public void setO_deposit(String o_deposit) {
		this.o_deposit = o_deposit;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

	public String getO_fix() {
		return o_fix;
	}

	public void setO_fix(String o_fix) {
		this.o_fix = o_fix;
	}

	public String getO_delivery() {
		return o_delivery;
	}

	public void setO_delivery(String o_delivery) {
		this.o_delivery = o_delivery;
	}

	public String getO_deliverydate() {
		return o_deliverydate;
	}

	public void setO_deliverydate(String o_deliverydate) {
		this.o_deliverydate = o_deliverydate;
	}

	public int getM_zipCode() {
		return m_zipCode;
	}

	public void setM_zipCode(int m_zipCode) {
		this.m_zipCode = m_zipCode;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public String getM_addrDetail() {
		return m_addrDetail;
	}

	public void setM_addrDetail(String m_addrDetail) {
		this.m_addrDetail = m_addrDetail;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		if(num%pageNumCount==0) {
			startPage = (num/pageNumCount-1)*pageNumCount+1;			
		}else {
			startPage = (num/pageNumCount)*pageNumCount+1;
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//총페이지수
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

	public String getO_selectColor() {
		return o_selectColor;
	}

	public void setO_selectColor(String o_selectColor) {
		this.o_selectColor = o_selectColor;
	}

}
