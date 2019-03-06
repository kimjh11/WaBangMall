package kr.wabang.member;

public class MemberVO {
	private int m_num;
	private String m_id;
	private String m_pwd;
	private String m_name;
	private String m_tel;
	private String[] m_telarr;//
	private String m_email;
	private String[] m_emailarr;//
	private String m_zipCode;
	private String m_addr;
	private String m_addrDetail;
	private String m_addrReference;
	private String m_regdate;
	
	//로그인 여부 (Y:로그인 성공, N:로그인 실패)
	private String loginStatus ="N";
	
	//생성자
	public MemberVO(){
		
	}
	public MemberVO(int m_num, String m_id, String m_pwd, String m_name, String m_tel, String m_email,
					String m_zipCode, String m_addr, String m_addrDetail, String m_addrReference, String m_regdate){
		this.m_num = m_num;
		this.m_id = m_id;
		this.m_pwd = m_pwd;
		this.m_name = m_name;
		this.m_tel = m_tel;
		this.m_email = m_email;
		this.m_zipCode = m_zipCode;
		this.m_addr = m_addr;
		this.m_addrDetail = m_addrDetail;
		this.m_addrReference = m_addrReference;
		this.m_regdate = m_regdate;
	}
	
	//getter/setter
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
		m_telarr = m_tel.split("-");
	}
	
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
		m_emailarr = m_email.split("@");
	}
	
	public String getM_zipCode() {
		return m_zipCode;
	}
	public void setM_zipCode(String m_zipCode) {
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
	public String getM_addrReference() {
		return m_addrReference;
	}
	public void setM_addrReference(String m_addrReference) {
		this.m_addrReference = m_addrReference;
	}
	
	public String getM_regdate() {
		return m_regdate;
	}
	public void setM_regdate(String m_regdate) {
		this.m_regdate = m_regdate;
	}
	
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	public String[] getM_telarr() {
		return m_telarr;
	}
	public void setM_telarr(String[] m_telarr) {
		this.m_telarr = m_telarr;
	}
	
	public String[] getM_emailarr() {
		return m_emailarr;
	}
	public void setM_emailarr(String[] m_emailarr) {
		this.m_emailarr = m_emailarr;
	}
}
