package kr.wabang.qna;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class QnaDAO extends DBConnection implements QnaInterface {
	
	@Override
	public int totalRecord(QnaVO vo) {
		//총 레코드 수
		int totalRecord = 0;
		try{
			dbCon();
			String sql = "select count(q_num) from question ";
			if(vo.getSearchKey() != null){
				//검색어가 있으면
				sql += "where "+vo.getSearchKey()+" like '%" + vo.getSearchWord() + "%'";
			}
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				totalRecord = rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println("총 레코드수 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return totalRecord;
	}
	
	@Override
	public List<QnaVO> pageList(QnaVO vo) {
		// 해당 페이지 레코드 리스트
		List<QnaVO> list = new ArrayList<QnaVO>();
			try{
				dbCon();
				String sql = "select * from (select * from "
						+ "(select q_num, m_id, q_title, q_content, to_char(q_regdate,'YY/MM/DD HH:mm:ss') "
						+ " from question ";
						if(vo.getSearchKey() != null){
							sql += " where "+vo.getSearchKey()+" like '%" +vo.getSearchWord()+ "%'";
						}
						sql += " order by q_num desc) "
							+" where rownum <= ? order by q_num asc) "
							+" where rownum <= ? order by q_num desc ";
						System.out.println(sql);
						pstmt = con.prepareStatement(sql);
						//               현재 페이지              한 페이지에 출력할 레코드 수 
						//	5,10,15,20,25....
						pstmt.setInt(1, vo.getNum()*vo.getOnePageRecord());
						System.out.println("vo.getNum()*vo.getOnePageRecord()="+vo.getNum()*vo.getOnePageRecord());
						//마지막 페이지의 레코드 선택
						//마지막 페이지에 남아있는 레코드 수
						//					        총 레코드 수	           한 페이지에 출력할 레코드 수 
						//							0        %        5
						int lastPageRecord = vo.getTotalRecord()%vo.getOnePageRecord();
						if(vo.getNum() == vo.getTotalPage()){
							// 1,2,3,4,0
							pstmt.setInt(2, lastPageRecord);
							System.out.println("lastPageRecord="+lastPageRecord);
						}else{
							// 5,5,5,5....
							pstmt.setInt(2, vo.getOnePageRecord());
							System.out.println("vo.getOnePageRecord()="+vo.getOnePageRecord());
						}
							
						if(vo.getNum() == vo.getTotalPage() && lastPageRecord == 0){
							pstmt.setInt(2, vo.getOnePageRecord());
						}
						rs = pstmt.executeQuery();
							
						while(rs.next()){
							QnaVO vo1 = new QnaVO();
							vo1.setQ_num(rs.getInt(1));
							vo1.setM_id(rs.getString(2));
							vo1.setQ_title(rs.getString(3));
							vo1.setQ_content(rs.getString(4));
							vo1.setQ_regdate(rs.getString(5));
								
							list.add(vo1);
						}
			}catch(Exception e){
				System.out.println("해당 페이지 레코드 리스트 에러"+e.getMessage());
			}finally{
				dbClose();
		}
		return list;
	}
	
	@Override
	public int QnaInsert(QnaVO vo) {
		// 질문 글 쓰기
		int cnt = 0;
		try{
			dbCon();
			String sql = "insert into question(q_num, m_id, q_title, q_content, q_regdate) "
					+ "values(questionSq.nextVal, ?,?,?, sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getQ_title());
			pstmt.setString(3, vo.getQ_content());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("질문 글쓰기 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public void selectQnaView(QnaVO vo) {
		// 질문 글 보기
		try{
			dbCon();
			String sql ="select * from question where q_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getQ_num());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo.setQ_num(rs.getInt(1));
				vo.setM_id(rs.getString(2));
				vo.setQ_title(rs.getString(3));
				vo.setQ_content(rs.getString(4));
				vo.setQ_regdate(rs.getString(5));
			}
		}catch(Exception e){
			System.out.println("질문 글 보기 에러"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public int updateQnaView(QnaVO vo) {
		// 질문 글 수정
		int cnt =0;
		try{
			dbCon();
			String sql = "update question set q_title=?, q_content=? "
					+ "where q_num=? and m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getQ_title());
			pstmt.setString(2, vo.getQ_content());
			pstmt.setInt(3, vo.getQ_num());
			pstmt.setString(4, vo.getM_id());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("질문 글 수정 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int deleteQnaView(QnaVO vo) {
		//질문 글 삭제
		int cnt = 0;
		try{
			dbCon();
			String sql = "delete from question where m_id=? and q_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getM_id());
			pstmt.setInt(2, vo.getQ_num());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("질문 글 삭제 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public void selectAnswer(AnswerVO vo) {
		// 답변 내용 가져오기
		try{
			dbCon();
			String sql ="select * from answer where q_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getQ_num());
				
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo.setQ_num(rs.getInt(1));
				vo.setAdminId(rs.getString(2));
				vo.setM_id(rs.getString(3));
				vo.setA_comment(rs.getString(4));
				vo.setA_regdate(rs.getString(5));
			}
			
		}catch(Exception e){
			System.out.println("답변 내용 가져오기 에러"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public int deleteAnswer(AnswerVO answervo) {
		// 답변 지우기
		int cnt = 0;
		try{
			dbCon();
			String sql = "delete from answer where m_id=? and q_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, answervo.getM_id());
			pstmt.setInt(2, answervo.getQ_num());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("답변 글 삭제 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int deleteQnaAnswer(String userid) {
		// 답변 지우기 -회원탈퇴
		int answerCnt =0;
		try{
			dbCon();
			String sql = "delete from answer where m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			answerCnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("답변 지우기 -회원탈퇴 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return answerCnt;
	}

	@Override
	public int deletequestion(String userid) {
		// 질문 지우기 -회원탈퇴
		int questionCnt =0;
		try{
			dbCon();
			String sql = "delete from question where m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			questionCnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("질문 지우기 -회원탈퇴 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return questionCnt;
	}
}
