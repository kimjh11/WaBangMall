package kr.wabang.qna;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class QnaDAO extends DBConnection implements QnaInterface {
	
	@Override
	public int totalRecord(QnaVO vo) {
		//�� ���ڵ� ��
		int totalRecord = 0;
		try{
			dbCon();
			String sql = "select count(q_num) from question ";
			if(vo.getSearchKey() != null){
				//�˻�� ������
				sql += "where "+vo.getSearchKey()+" like '%" + vo.getSearchWord() + "%'";
			}
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				totalRecord = rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println("�� ���ڵ�� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return totalRecord;
	}
	
	@Override
	public List<QnaVO> pageList(QnaVO vo) {
		// �ش� ������ ���ڵ� ����Ʈ
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
						//               ���� ������              �� �������� ����� ���ڵ� �� 
						//	5,10,15,20,25....
						pstmt.setInt(1, vo.getNum()*vo.getOnePageRecord());
						System.out.println("vo.getNum()*vo.getOnePageRecord()="+vo.getNum()*vo.getOnePageRecord());
						//������ �������� ���ڵ� ����
						//������ �������� �����ִ� ���ڵ� ��
						//					        �� ���ڵ� ��	           �� �������� ����� ���ڵ� �� 
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
				System.out.println("�ش� ������ ���ڵ� ����Ʈ ����"+e.getMessage());
			}finally{
				dbClose();
		}
		return list;
	}
	
	@Override
	public int QnaInsert(QnaVO vo) {
		// ���� �� ����
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
			System.out.println("���� �۾��� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public void selectQnaView(QnaVO vo) {
		// ���� �� ����
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
			System.out.println("���� �� ���� ����"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public int updateQnaView(QnaVO vo) {
		// ���� �� ����
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
			System.out.println("���� �� ���� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int deleteQnaView(QnaVO vo) {
		//���� �� ����
		int cnt = 0;
		try{
			dbCon();
			String sql = "delete from question where m_id=? and q_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getM_id());
			pstmt.setInt(2, vo.getQ_num());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("���� �� ���� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public void selectAnswer(AnswerVO vo) {
		// �亯 ���� ��������
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
			System.out.println("�亯 ���� �������� ����"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public int deleteAnswer(AnswerVO answervo) {
		// �亯 �����
		int cnt = 0;
		try{
			dbCon();
			String sql = "delete from answer where m_id=? and q_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, answervo.getM_id());
			pstmt.setInt(2, answervo.getQ_num());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("�亯 �� ���� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int deleteQnaAnswer(String userid) {
		// �亯 ����� -ȸ��Ż��
		int answerCnt =0;
		try{
			dbCon();
			String sql = "delete from answer where m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			answerCnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("�亯 ����� -ȸ��Ż�� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return answerCnt;
	}

	@Override
	public int deletequestion(String userid) {
		// ���� ����� -ȸ��Ż��
		int questionCnt =0;
		try{
			dbCon();
			String sql = "delete from question where m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			questionCnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("���� ����� -ȸ��Ż�� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return questionCnt;
	}
}
