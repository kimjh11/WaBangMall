package kr.wabang.notice;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class NoticeDAO extends DBConnection implements NoticeInterface {
	
	@Override
	public int totalRecord(NoticeVO vo) {
		//총 레코드 수
		int totalRecord = 0;
		try{
			dbCon();
			String sql = "select count(n_num) from notice ";
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
	public List<NoticeVO> pageList(NoticeVO vo) {
		// 해당 페이지 레코드 리스트
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
						NoticeVO vo1 = new NoticeVO();
						vo1.setAdminId(rs.getString(1));
						vo1.setN_num(rs.getInt(2));
						vo1.setN_title(rs.getString(3));
						vo1.setN_content(rs.getString(4));
						vo1.setN_regdate(rs.getString(5));
						
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
	public int NoticeInsert(NoticeVO vo) {
		//글 등록
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
			System.out.println("공지사항 등록 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public void selectNoticeView(NoticeVO vo) {
		//글 보기(선택)
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
			System.out.println("글 보기 에러"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public int updateNoticeView(NoticeVO vo) {
		//글 수정
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
			System.out.println("글 수정 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int deleteNoticeView(NoticeVO vo) {
		//글 삭제
		int cnt = 0;
		try{
			dbCon();
			String sql = "delete from notice where adminId=? and n_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAdminId());
			pstmt.setInt(2, vo.getN_num());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("글 삭제 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

}
