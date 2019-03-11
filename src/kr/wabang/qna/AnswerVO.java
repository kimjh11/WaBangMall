package kr.wabang.qna;

public class AnswerVO {
	private int q_num;
	private String adminId;
	private String m_id;
	private String a_comment;
	private String a_regdate;
	
	//
	public AnswerVO() {
	
	}
	
	//getter/setter
	public int getQ_num() {
		return q_num;
	}

	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getA_comment() {
		return a_comment;
	}

	public void setA_comment(String a_comment) {
		this.a_comment = a_comment;
	}

	public String getA_regdate() {
		return a_regdate;
	}

	public void setA_regdate(String a_regdate) {
		this.a_regdate = a_regdate;
	}
}
