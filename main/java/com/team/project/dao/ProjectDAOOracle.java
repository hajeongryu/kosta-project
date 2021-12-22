package com.team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.project.vo.Project;
import com.team.sql.MyConnection;

public class ProjectDAOOracle implements ProjectDAOInterface{
	private static ProjectDAOOracle dao = new ProjectDAOOracle();
	private ProjectDAOOracle() {
		
	}
	public static ProjectDAOOracle getInstance() {
		return dao;
	}
	@Override
	public List<Project> findAll() throws FindException {
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신
		String selectAllSQL = "SELECT * FROM project ORDER BY project_no ASC";
		List<Project> list = new ArrayList<>();
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectAllSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int projtNo = rs.getInt("project_no");
				String projtName = rs.getString("prod_name");
				int prodPrice = rs.getInt("prod_price");
				Project p = new Project();
				list.add(p);
			}
			if(list.size() == 0) {
				throw new FindException("상품이 없습니다");
=======
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.team.exception.FindException;
import com.team.project.vo.DisplayProjectType;
import com.team.sql.MyConnection;

public class ProjectDAOOracle implements ProjectDAOInterface {



	@Override
	public DisplayProjectType findByProjectNo(int inProjectNo) throws FindException {
		Connection con =null;
		Statement stmt = null;
		ResultSet rs= null;
		
		String selectSQL = "SELECT  p.project_no"
								+ ",category_name "
								+ ", user_name "
								+ ", long_title"
								+ ", target_price"
								+ ", sum_price "
								+ ", end_date "
								+ ", support_cnt"
								+ ", project_image"
					+ " FROM project p"
					+ "    JOIN project_change c"
					+ "        ON p.project_no =c.project_no"
					+ "    JOIN users u"
					+ "        ON p.user_no = u.user_no"
					+ "    JOIN category cate"
					+ "        ON p.category_no = cate.category_no";
		try {
			con = MyConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectSQL);
			
			while(rs.next()) {
				int	projectNo = rs.getInt("p.project_no");
				String cateogryName = rs.getString("category_name");
				String userName = rs.getString("user_name"); 
				String longTitle = rs.getString("long_title"); 
				int target_price = rs.getInt("target_price");
				int sum_price = rs.getInt("end_date ");
				java.sql.Date endDate =rs.getDate("end_date");
				int spoortCnt = rs.getInt("support_cnt");
				String projectImage = rs.getString("project_image");
				
				DisplayProjectType dpt = 
						new DisplayProjectType(projectNo, cateogryName, userName, 
												longTitle, target_price, sum_price, 
												endDate, spoortCnt, projectImage);


				if (dpt.projectNo == inProjectNo) {
					return dpt;
				}
				
			}

			throw new FindException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException();
		}finally {
			MyConnection.close(rs,stmt,con);
		}
		
	}
	
	//TODO : findbyuserNo 만들기
	//TODO : 주목할만한 프로젝트
								//public  List<DisplayProjectType> findAttentionProject();

	
	
	public	List<DisplayProjectType> findProject(String category,  //service쪽에서 카테고리 null 값받으면 String값 "all" 넣어서 전달
												 String ongoing,
												 String editorPick,
												 String achiveRate,
												 String sort) throws FindException{
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		List<DisplayProjectType> list= new ArrayList<DisplayProjectType>();
		String selectSQL = "SELECT  p.project_no "
								+ ",category_name "
								+ ", user_name "
								+ ", long_title"
								+ ", target_price"
								+ ", sum_price "
								+ ", end_date "
								+ ", support_cnt"
								+ ", project_image"
					+ " FROM project p"
					+ "    JOIN project_change c"
					+ "        ON p.project_no =c.project_no"
					+ "    JOIN users u"
					+ "        ON p.user_no = u.user_no"
					+ "    JOIN category cate"
					+ "        ON p.category_no = cate.category_no";
		
		
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			
			selectSQL= categoryAndSQLAdd(category, selectSQL);
			selectSQL= ongoingAndSQLAdd(ongoing, selectSQL);
			selectSQL=editorPickAndSQLAdd(editorPick, selectSQL); 
			selectSQL = achiveRateAndSQLAdd(achiveRate, selectSQL);
			selectSQL = sortAndSQLAdd(sort, selectSQL);

			//전체카테고리가 아닐경우setString 실행 
			if(category != "all"  ) {
				pstmt.setString(1, category);
			}
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int	projectNo = rs.getInt("p.project_no");
				String cateogryName = rs.getString("category_name");
				String userName = rs.getString("user_name"); 
				String longTitle = rs.getString("long_title"); 
				int target_price = rs.getInt("target_price");
				int sum_price = rs.getInt("end_date ");
				java.sql.Date endDate =rs.getDate("end_date");
				int spoortCnt = rs.getInt("support_cnt");
				String projectImage = rs.getString("project_image");
				
				DisplayProjectType dpt = 
						new DisplayProjectType(projectNo, cateogryName, userName, 
												longTitle, target_price, sum_price, 
												endDate, spoortCnt, projectImage);
				
				list.add(dpt);
			}

			if(list.isEmpty()) {
				throw new FindException();
>>>>>>> main
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
<<<<<<< HEAD
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
	}
	@Override
	public Project findByProjectNo(int ProjectNo) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void add(Project project) throws AddException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modify(Project project) throws ModifyException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(int projectNo) throws RemoveException {
		// TODO Auto-generated method stub
		
=======
			throw new FindException();
		}finally {
			MyConnection.close(rs,pstmt,con);
		}
		
	}

	private String categoryAndSQLAdd (String category, String selectSQL)  throws FindException{
			//requnset value: onging
			//1. 진행중 프로젝트
		final int NOT_SELECT_SQL= 10;

		if(selectSQL.length() <NOT_SELECT_SQL) {
				throw new FindException("잘못된 category 파라미터");
			}
		
			if(category =="all") {
				selectSQL +="WHERE p.category_no >=0 ";
			}else {
				selectSQL +="WHERE p.category_no >= ? ";
			}
				
			return selectSQL;
	}
	
	
	
	
	
	
	/**
	 * 반드시 ongoing이 앞에올것
	 * @param ongoing
	 * @param selectSQL
	 * @return
	 */
	private String ongoingAndSQLAdd (String ongoing , String selectSQL)  throws FindException{
			//@리퀘스트 값 "categoty" = "all" / "board-games-and-trpg (1)" 등등..    / null ==> service에서 all로전달


			final int NOT_SELECT_SQL= 10;

			if(selectSQL.length() <NOT_SELECT_SQL) {
				throw new FindException("잘못된 ongoing `파라미터");
			}
		
			if(ongoing =="ongoing") {
				selectSQL +="AND c.project_status = '승인' ";
				selectSQL +="AND sysdate > P.start_date ";
				selectSQL +="AND 0>= (sysdate -p.end_date ) ";
			//2. 성사된 프로젝트
			}else if(ongoing =="confirm"){
				selectSQL +="AND 0< (sysdate - p.end_date)";
				selectSQL +="AND c.sum_price > p.target_price";
			//3. 공개예정 프로젝트
			}else if(ongoing =="prelaunching"){
				selectSQL +="AND c.project_status = '승인'";
				selectSQL +="AND sysdate  < p.start_date";
			}
			
			return selectSQL;
	}
	
	private String editorPickAndSQLAdd (String editorPick, String selectSQL)  throws FindException{
			//리퀘스트값 editorpick = "1" / null
		final int NOT_SELECT_SQL= 10;

		if(selectSQL.length() <NOT_SELECT_SQL) {
			throw new FindException("잘못된 editorPick 파라미터");
		}

		//3-1.에디터 추천 프로젝트(1)
		if(editorPick =="1") {
			selectSQL +="AND p.editor_pick = '1'";
		}
		return selectSQL;
	}
	
	private String achiveRateAndSQLAdd (String achiveRate, String selectSQL)  throws FindException{
			//@리퀘스트값 achieveRate=    "1" 75%이하   "2"75~100%    "3:100% 이상  / null
		final int NOT_SELECT_SQL= 10;

		if(selectSQL.length() <NOT_SELECT_SQL) {
			throw new FindException("잘못된 achiveRate 파라미터");
			}
	
		//4-1.  75% 이하 달성률
		if(achiveRate =="1") {
			selectSQL+= "AND (c.sum_price / p.target_price) <0.75";

		//4-2.  75~100% 달성률	
		}else if(achiveRate =="2") {
			selectSQL+= "AND (c.sum_price / p.target_price) BETWEEN 0.75 AND 1.00";

		//4-3.  100%이상 달성률
		}else if (achiveRate =="3") {
			selectSQL+= "AND (c.sum_price / p.target_price) >1.00";
			
		}

		return selectSQL;
	}
	
	private String sortAndSQLAdd (String sort, String selectSQL) throws FindException {
			//@리퀘스트값 sort = popular(인기순)	publishedAt(최신순)	pledges(후원순)	amount(금액순) ended(마감 임박순)
		final int NOT_SELECT_SQL= 10;

		if(selectSQL.length() <NOT_SELECT_SQL) {
			throw new FindException("잘못된 sort 파라미터");
			}

		//1.popular(인기순) 좋아요순
		if(sort=="popular") {
			selectSQL +="ORDER BY c.project_like_cnt DESC";

		//2.pledges(후원순)
		}else if(sort=="pledges"){
			selectSQL +="ORDER BY c.support_cnt DESC";

		//3.amount(금액순)
		}else if(sort=="amount"){
			selectSQL +="ORDER BY c.sum_price DESC";

		//4.publishedAt(최신순)
		}else if(sort=="publishedAt"){
			selectSQL +="AND c.project_status = '승인' ";
			selectSQL +="ORDER BY p.start_date DESC";

		//5.ended(마감 임박순)
		}else if(sort=="ended"){
			selectSQL +="AND p.end_date<sysdate";
			selectSQL +="ORDER BY p.end_date ASC";

		}	
		return selectSQL;

>>>>>>> main
	}
	
	
}
