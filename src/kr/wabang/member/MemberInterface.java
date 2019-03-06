package kr.wabang.member;

public interface MemberInterface {
	
	//회원 가입(insert)
	public int memberInsert(MemberVO vo);
	//아이디 중복 검사
	public int idCheck(String userid);
	//로그인 체크
	public void loginCheck(MemberVO vo);
	//회원 수정(select)-선택
	public MemberVO myInfoSelect(String userid);
	//회원 수정(update)
	public int myInfoUpdate(MemberVO vo);
	
	//회원 탈퇴(delete)
	
	//아이디 찾기
	//비밀번호 찾기
}
