package kr.wabang.member;

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
	
	//���̵� ã��
	//��й�ȣ ã��
}
