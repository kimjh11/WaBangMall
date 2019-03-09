package kr.wabang.member;

import java.util.List;

public interface MemberInterface {
	//ȸ�� ����(insert)
	public int memberInsert(MemberVO vo);
	
	//���̵� �ߺ� �˻�
	public int idCheck(String userid);
	
	//�α��� üũ
	public void loginCheck(MemberVO vo);
	
	//ȸ�� ����(select)-����
	public MemberVO myInfoSelect(String userid);
	
	//ȸ�� ����(update)
	public int myInfoUpdate(MemberVO vo);
	
	//ȸ�� Ż��(delete)
	public int myInfoDelete(String userid, MemberVO vo);
	
	//���� �α��� �ϱ�
	public void adminloginCheck(AdminVO adminvo);
	
	//���̵� ã��
	public MemberVO findId(String email);
	//��й�ȣ ã��
	public MemberVO findPwd(String userid,String email);
}
