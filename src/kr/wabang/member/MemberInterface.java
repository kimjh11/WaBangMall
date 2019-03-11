package kr.wabang.member;

import java.util.List;

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
	public int myInfoDelete(String userid, MemberVO vo);
	
	//어드민 로그인 하기
	public void adminloginCheck(AdminVO adminvo);
	
	//아이디 찾기
	public MemberVO findId(String email);
	//비밀번호 찾기
	public MemberVO findPwd(String userid,String email);
}
