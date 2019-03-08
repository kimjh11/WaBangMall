package kr.wabang.member;

public class AdminVO {
	
	private String adminId;
	private String adminPwd;
	
	//로그인 여부 (Y:로그인 성공, N:로그인 실패)
	private String adminloginStatus ="N";
	
	//생성자
	public AdminVO() {
		
	}
	
	public AdminVO(String adminId, String adminPwd){
		this.adminId = adminId;
		this.adminPwd = adminPwd;
	}
	
	//getter/setter
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminloginStatus() {
		return adminloginStatus;
	}
	public void setAdminloginStatus(String adminloginStatus) {
		this.adminloginStatus = adminloginStatus;
	}

}
