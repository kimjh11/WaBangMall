package kr.wabang.notice;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class NoticeDAO extends DBConnection implements NoticeInterface {
	
	@Override
	public int totalRecord(NoticeVO vo) {
		//�� ���ڵ� ��
		int totalRecord = 0;
		try{
			dbCon();
			String sql = "select count(n_num) from notice ";
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
	public List<NoticeVO> pageList(NoticeVO vo) {
		// �ش� ������ ���ڵ� ����Ʈ
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try{
			dbCon();
			String sql = "select * from (select * from "
					+ "(select adminId, n_num, n_title, n_content, to_char(n_regdate,'YY/MM/DD HH:mm:ss') "
					+ " from notice ";
					if(vo.getSearchKey() != null){
						sql += " where "+vo.getSearchKey()+" like '%" +vo.getSearchWord()+ "%'";
					}
					sql += " order by n_num desc) "
						+" where rownum <= ? order by n_num asc) "
						+" where rownum <= ? order by n_num desc ";
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
						NoticeVO vo1 = new NoticeVO();
						vo1.setAdminId(rs.getString(1));
						vo1.setN_num(rs.getInt(2));
						vo1.setN_title(rs.getString(3));
						vo1.setN_content(rs.getString(4));
						vo1.setN_regdate(rs.getString(5));
						
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
	public int NoticeInsert(NoticeVO vo) {
		//�� ���
		int cnt = 0;
		try{
			dbCon();
			String sql = "insert into notice(n_num, adminid, n_title, n_content, n_regdate) "
					+ "values (noticeSq.nextVal, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAdminId());
			pstmt.setString(2, vo.getN_title());
			pstmt.setString(3, vo.getN_content());
			
			System.out.println(vo.getAdminId());
			System.out.println(vo.getN_title());
			System.out.println(vo.getN_content());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("�������� ��� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public void selectNoticeView(NoticeVO vo) {
		//�� ����(����)
		try{
			dbCon();
			String sql = "select * from notice where n_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getN_num());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo.setAdminId(rs.getString(1));
				vo.setN_num(rs.getInt(2));
				vo.setN_title(rs.getString(3));
				vo.setN_content(rs.getString(4));
				vo.setN_regdate(rs.getString(5));
			}
		}catch(Exception e){
			System.out.println("�� ���� ����"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public int updateNoticeView(NoticeVO vo) {
		//�� ����
		int cnt = 0;
		try{
			dbCon();
			String sql = "update notice set n_title=?, n_content=? "
					+ "where n_num=? and adminId=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getN_title());
			pstmt.setString(2, vo.getN_content());
			pstmt.setInt(3, vo.getN_num());
			pstmt.setString(4, vo.getAdminId());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("�� ���� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int deleteNoticeView(NoticeVO vo) {
		//�� ����
		int cnt = 0;
		try{
			dbCon();
			String sql = "delete from notice where adminId=? and n_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAdminId());
			pstmt.setInt(2, vo.getN_num());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("�� ���� ����"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

}
