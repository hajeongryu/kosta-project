package com.team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.project.vo.Category;
import com.team.project.vo.Project;
import com.team.project.vo.ProjectChange;
import com.team.project.vo.Reward;
import com.team.sql.MyConnection;
import com.team.user.vo.Users;


public class ProjectDAOOracle implements ProjectDAOInterface {
	//TODO : findbyuserNo 만들기
	//TODO : 주목할만한 프로젝트
	//public  List<DisplayProjectType> findAttentionProject();
	
		private static ProjectDAOOracle dao = new ProjectDAOOracle();
	private ProjectDAOOracle() {
		
	}
	public static ProjectDAOOracle getInstance() {
		return dao;
	}



	@Override
	public List<Project> findAll() throws FindException {
		Connection con = null; //DB연결
		Statement stmt = null; //SQL송신
		ResultSet rs = null; //결과 수신
		List<Project> list = new ArrayList<>();
		
		String selectSQL = "SELECT  p.project_no"
								+ ", category_name "
								+ ", user_name "
								+ ", long_title "
								+ ", project_content "
								+ ", project_brief"
								+ ", target_price "
								+ ", sum_price "
								+ ", end_date "
								+ ", support_cnt "
								+ ", project_image "
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

				Project project= new Project();

				//Project Table
				int	projectNo = rs.getInt("project_no");
				String longTitle = rs.getString("long_title"); 
				String projectContent= rs.getString("project_content"); 
				int targetPrice = rs.getInt("target_price");
				Date endDate =rs.getDate("end_date");
				String projectImage = rs.getString("project_image");
				String projectBrief = rs.getString("project_brief");

				project.setProjectNo(projectNo);
				project.setLongTitle(longTitle);
				project.setTargetPrice(targetPrice);
				project.setEndDate(endDate);
				project.setProjectImage(projectImage);
				project.setProjectContent(projectContent);
				project.setProjectBrief(projectBrief);

				//[JOIN] ProjectChange 
				int sumPrice = rs.getInt("sum_price");
				int spoortCnt = rs.getInt("support_cnt");
				ProjectChange pc = new ProjectChange();
				pc.setSumPrice(sumPrice);
				pc.setSupportCnt(spoortCnt);
				
				project.setProjectChange(pc);
				
				//[JOIN] Cateogty Talbe
				String cateogryName = rs.getString("category_name");
				Category categotyObject = new Category();
				categotyObject.setCategoryName(cateogryName);
				
				project.setCategory(categotyObject);
				
				
				//[JOIN] Users Table
				String userName = rs.getString("user_name"); 
				Users user = new Users();
				user.setUserName(userName);
				
				project.setMaker(user);
				
				
				list.add(project);
			}
			
			
			if(list.isEmpty()) {
				throw new FindException();
			}

			return list;

			}catch (Exception e) {
				throw new FindException("상품이 없습니다");
			}finally {
				MyConnection.close(rs,stmt,con);
			}
		}


	@Override
	public Project findByProjectNo(int inProjectNo) throws FindException {
	Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		String selectSQL = "SELECT  p.project_no"
								+ ", category_name "
								+ ", user_name "
								+ ", long_title "
								+ ", project_content "
								+ ", project_brief"
								+ ", target_price "
								+ ", sum_price "
								+ ", end_date "
								+ ", support_cnt "
								+ ", project_image "
					+ " FROM project p"
					+ "    JOIN project_change c"
					+ "        ON p.project_no =c.project_no"
					+ "    JOIN users u"
					+ "        ON p.user_no = u.user_no"
					+ "    JOIN category cate"
					+ "        ON p.category_no = cate.category_no"
					+ " WHERE p.project_no = ?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, inProjectNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				Project project= new Project();

				//Project Table
				int	projectNo = rs.getInt("project_no");
				String longTitle = rs.getString("long_title"); 
				String projectContent= rs.getString("project_content"); 
				int targetPrice = rs.getInt("target_price");
				Date endDate =rs.getDate("end_date");
				String projectImage = rs.getString("project_image");
				String projectBrief = rs.getString("project_brief");

				project.setProjectNo(projectNo);
				project.setLongTitle(longTitle);
				project.setTargetPrice(targetPrice);
				project.setEndDate(endDate);
				project.setProjectImage(projectImage);
				project.setProjectContent(projectContent);
				project.setProjectBrief(projectBrief);

				//[JOIN] ProjectChange 
				int sumPrice = rs.getInt("sum_price");
				int spoortCnt = rs.getInt("support_cnt");
				ProjectChange pc = new ProjectChange();
				pc.setSumPrice(sumPrice);
				pc.setSupportCnt(spoortCnt);
				
				project.setProjectChange(pc);
				
				//[JOIN] Cateogty Talbe
				String cateogryName = rs.getString("category_name");
				Category cate = new Category();
				cate.setCategoryName(cateogryName);
				
				project.setCategory(cate);
				
				
				//[JOIN] Users Table
				String userName = rs.getString("user_name"); 
				Users user = new Users();
				user.setUserName(userName);
				
				project.setMaker(user);
				
				return project;
			}

			throw new FindException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException();
		}finally {
			MyConnection.close(rs,pstmt,con);
		}
		
	}


	
	@Override
	public List<Project> findByUserNo(int inUserNo) throws FindException {
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<Project> list= new ArrayList<Project>();

		String selectSQL = "SELECT  p.project_no"
								+ ", category_name"
								+ ", user_name"
								+ ", long_title"
								+ ", project_content"
								+ ", project_brief"
								+ ", target_price"
								+ ", sum_price"
								+ ", end_date"
								+ ", support_cnt"
								+ ", project_image"
					+ " FROM project p"
					+ " JOIN project_change c"
					+ "   ON p.project_no =c.project_no"
					+ " JOIN users u"
					+ "   ON p.user_no = u.user_no"
					+ " JOIN category cate"
					+ "   ON p.category_no = cate.category_no"
					+ " WHERE p.user_no = ?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			
			//맞는지?
			pstmt.setInt(1, inUserNo);
			rs = pstmt.executeQuery();
			System.out.println("a");
			
			while(rs.next()) {

				Project project= new Project();

				//Project Table

				int	projectNo = rs.getInt("project_no");
				String longTitle = rs.getString("long_title"); 
				System.out.println(longTitle);
				String projectContent= rs.getString("project_content"); 
				int targetPrice = rs.getInt("target_price");
				Date endDate =rs.getDate("end_date");
				String projectImage = rs.getString("project_image");
				String projectBrief = rs.getString("project_brief");

				project.setProjectNo(projectNo);
				project.setLongTitle(longTitle);
				project.setTargetPrice(targetPrice);
				project.setEndDate(endDate);
				project.setProjectImage(projectImage);
				project.setProjectContent(projectContent);
				project.setProjectBrief(projectBrief);

				//[JOIN] ProjectChange 
				int sumPrice = rs.getInt("sum_price");
				int spoortCnt = rs.getInt("support_cnt");
				ProjectChange pc = new ProjectChange();
				pc.setSumPrice(sumPrice);
				pc.setSupportCnt(spoortCnt);
				
				project.setProjectChange(pc);
				
				//[JOIN] Cateogty Talbe
				String cateogryName = rs.getString("category_name");
				Category cate = new Category();
				cate.setCategoryName(cateogryName);
				
				project.setCategory(cate);
				
				
				//[JOIN] Users Table
				String userName = rs.getString("user_name"); 
				Users user = new Users();
				user.setUserName(userName);
				
				project.setMaker(user);
				
				list.add(project);
			}
			if(list.isEmpty()) {
				throw new FindException();
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException();
		}finally {
			MyConnection.close(rs,pstmt,con);
		}
	}

	
	
	@Override
	public List<Reward> findReward(int inProjectNo) throws FindException {
		// TODO Auto-generated method stub
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신

		List<Reward> list= new ArrayList<Reward>();

		String selectSQL = "SELECT reward_no"
						+ ", reward_price"
						+ ", reward_name"
						+ ", deliver_date"
						+ ", reward_num"
						+ ", reward_sales_cnt"
						+ ", item_name"
						+ ", deliver_select"
				+ " FROM reward"
				+ " WHERE project_no =?";
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, inProjectNo);
			
			rs=pstmt.executeQuery();
			
		

			while(rs.next()) {
				Reward rw = new Reward();
		
				
				// Reward Table
				int rewardNo= rs.getInt("reward_no");
				int rewardPrice= rs.getInt("reward_price");
				String rewardName= rs.getString("reward_name"); 
				int deliverDate= rs.getInt("deliver_date");
				int rewardNum= rs.getInt("reward_num");
				int rewardSaleCnt= rs.getInt("reward_sales_cnt");
				String itemName= rs.getString("item_name"); 
				String deliverSelect= rs.getString("deliver_select"); 

				rw.setRewardNo(rewardNo);
				rw.setRewardPrice(rewardPrice);
				rw.setRewardName(rewardName);
				rw.setDeliverDate(deliverDate);
				rw.setRewardNum(rewardNum);
				rw.setRewardSalesCnt(rewardSaleCnt);
				rw.setItemName(itemName);
				rw.setDeliverSelect(deliverSelect);
				
				list.add(rw);
			}
			
			
			if(list.isEmpty()) {
				throw new FindException("상품이 없습니다");
			}

			return list;

			}catch (Exception e) {
				e.printStackTrace();
				throw new FindException();
			}finally {
				MyConnection.close(rs,pstmt,con);
			}

	}

	
	
	
	
	//TODO:  category값에 all 이나 null 이외의 값이 들어오면 처리해줘야함
	
	public	List<Project> findByRequestData(String category,  //service쪽에서 카테고리 null 값받으면 String값 "all" 넣어서 전달
											String ongoing,
											String editorPick,
											String achiveRate,
											String sort,
											String rowCount,
											String loginedUserNo) throws FindException{
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;

		if(category == null) {
			category ="all";
		}

		if(rowCount ==null) {
			rowCount ="100";
		}


		List<Project> findedProjectlist= new ArrayList<Project>();
		String selectSQL = "SELECT  p.project_no"
							+ ", category_name"
							+ ", user_name"
							+ ", long_title"
							+ ", project_content"
							+ ", project_brief"
							+ ", target_price"
							+ ", sum_price"
							+ ", end_date"
							+ ", support_cnt"
							+ ", project_image";
			if(loginedUserNo!= null) {
								// x(?) 유저의 좋아요 누른 여부
					selectSQL+=", i.user_no "; 
							}

			selectSQL+= " FROM project p"
							+ " JOIN project_change c"
								+ "   ON p.project_no =c.project_no"
							+ " JOIN users u"
								+ "   ON p.user_no = u.user_no"
							+ " JOIN category cate"
								+ "   ON p.category_no = cate.category_no";

			if(loginedUserNo != null) {
					selectSQL+=" LEFT OUTER JOIN interest i"
								  + " ON p.project_no = i.project_no AND i.user_no =? ";
			}

			
			selectSQL= categoryAndSQLAdd(category, selectSQL);
			selectSQL+= " AND ROWNUM <= ?";
			selectSQL= ongoingAndSQLAdd(ongoing, selectSQL);
			selectSQL=editorPickAndSQLAdd(editorPick, selectSQL); 
			selectSQL = achiveRateAndSQLAdd(achiveRate, selectSQL);
			selectSQL = sortAndSQLAdd(sort, selectSQL);

		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
		
			//전체카테고리가 아닐경우setString 실행 
			//cate = null  , 1
	
			//로그인 안했을때
			if(loginedUserNo== null) {

				if( category == "all") {
					pstmt.setString(1, rowCount);
				}else {
					pstmt.setString(1, category);
					pstmt.setString(2, rowCount);
				}
			//로그인 했을때
			}else {
				System.out.println(loginedUserNo);
				pstmt.setString(1, loginedUserNo);

				if( category == "all") {
					pstmt.setString(2, rowCount);
				}else {
					pstmt.setString(2, category);
					pstmt.setString(3, rowCount);
				}
			}
		
			rs = pstmt.executeQuery();
		
			while(rs.next()) {

				Project project= new Project();

				//Project Table
				int	projectNo = rs.getInt("project_no");
				String longTitle = rs.getString("long_title"); 
				String projectContent= rs.getString("project_content"); 
				int targetPrice = rs.getInt("target_price");
				Date endDate =rs.getDate("end_date");
				String projectImage = rs.getString("project_image");
				String projectBrief = rs.getString("project_brief");

				project.setProjectNo(projectNo);
				project.setLongTitle(longTitle);
				project.setTargetPrice(targetPrice);
				project.setEndDate(endDate);
				project.setProjectImage(projectImage);
				project.setProjectContent(projectContent);
				project.setProjectBrief(projectBrief);

				
				//[JOIN] ProjectChange 
				int sumPrice = rs.getInt("sum_price");
				int spoortCnt = rs.getInt("support_cnt");
				ProjectChange pc = new ProjectChange();
				pc.setSumPrice(sumPrice);
				pc.setSupportCnt(spoortCnt);
				
				project.setProjectChange(pc);
				
				
				//[JOIN] Cateogty Talbe
				String cateogryName = rs.getString("category_name");
				Category categoryObj = new Category();
				categoryObj.setCategoryName(cateogryName);
				
				project.setCategory(categoryObj);
				
				
				//[JOIN] Users Table
				String userName = rs.getString("user_name"); 
				Users userObj = new Users();
				userObj.setUserName(userName);
				
				project.setMaker(userObj);
				
				
				if(loginedUserNo != null) {
					String interestUserNo = rs.getString("user_no");
					if(interestUserNo !=null ) {
						project.setLoginedUserProjectInterest(true);;
					}
				}
				

				findedProjectlist.add(project);
			}

			if(findedProjectlist.isEmpty()) {
				throw new FindException("프로젝트를 찾지 못하였습니다. isEmpty()");
			}
			return findedProjectlist;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
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
		
	}
	
	
	

	

	//내부 매소드-------------------------------------------------------------------------------------
	
	
	private String categoryAndSQLAdd (String category, String selectSQL)  throws FindException{
			//@리퀘스트 값 "categoty" = "all" / "board-games-and-trpg (1)" 등등..    / null ==> service에서 all로전달
		final int NOT_SELECT_SQL= 10;

		if(selectSQL.length() <NOT_SELECT_SQL) {
				throw new FindException("잘못된 category 파라미터");
			}
		
			if(category =="all") {
				selectSQL +=" WHERE p.category_no >=0 ";
			}
			else {
				selectSQL +=" WHERE p.category_no = ? ";
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


			final int NOT_SELECT_SQL= 10;

			if(selectSQL.length() <NOT_SELECT_SQL) {
				throw new FindException("잘못된 ongoing `파라미터");
			}
		
			//1.진행중
			if(ongoing =="onGoing") {
				selectSQL +=" AND c.project_status = '승인' ";
				selectSQL +=" AND sysdate > p.start_date ";
				selectSQL +=" AND sysdate < p.end_date  ";

			//2. 성사된 프로젝트
			}else if(ongoing =="confirm"){
				selectSQL +=" AND c.project_status = '승인'";
				selectSQL +=" AND  sysdate > p.end_date ";
				selectSQL +=" AND c.sum_price > p.target_price";

			//3. 공개예정 프로젝트
			}else if(ongoing =="prelaunching"){
				selectSQL +=" AND c.project_status = '승인'";
				selectSQL +=" AND sysdate  < p.start_date";
			}else if(ongoing ==null){
			}
			else {
				throw new FindException("ongoing 값이 잘못되었습니다.");
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
			selectSQL +=" AND p.editor_pick = '1'";
		}else if(editorPick==null){
		}
		else {
				throw new FindException("editorPick 값이 잘못되었습니다.");
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
			selectSQL+= " AND (c.sum_price / p.target_price) <0.75";

		//4-2.  75~100% 달성률	
		}else if(achiveRate =="2") {
			selectSQL+= " AND (c.sum_price / p.target_price) BETWEEN 0.75 AND 1.00";

		//4-3.  100%이상 달성률
		}else if (achiveRate =="3") {
			selectSQL+= " AND (c.sum_price / p.target_price) >1.00";
			
		}else if(achiveRate==null){
		}
		else {
				throw new FindException("achiveRate 값이 잘못되었습니다.");
			}

		return selectSQL;
	}
	
	private String sortAndSQLAdd (String sort, String selectSQL) throws FindException {
			//@리퀘스트값 sort = popular(인기순)	publishedAt(최신순)	pledges(후원순)	amount(금액순) endcome(마감 임박순), 
		final int NOT_SELECT_SQL= 10;

		//마감임박 프로젝트 일수 ex) 10 = 마감10일전
		final int ENDCOME_DATE= 10;	
		
		//프로젝트 시작 후! 14일까지 신규프로젝트로 취급  //
		final int PUBLISHED_MIN_DAY= 14;

		if(selectSQL.length() <NOT_SELECT_SQL) {
			throw new FindException("잘못된 sort 파라미터");
			}

		//1.popular(인기순) 좋아요순
		if(sort=="popular") {
			selectSQL +=" ORDER BY c.project_like_cnt DESC";

		//2.pledges(후원순)
		}else if(sort=="pledges"){
			selectSQL +=" ORDER BY c.support_cnt DESC";

		//3.amount(금액순)
		}else if(sort=="amount"){
			selectSQL +=" ORDER BY c.sum_price DESC";

		//4.publishedAt(최신순)
		}else if(sort=="publishedAt"){
			selectSQL+= "AND  "+PUBLISHED_MIN_DAY+">= (sysdate - p.start_date)";
			selectSQL +=" ORDER BY p.start_date DESC";

		//5.ended(마감 임박순)
		}else if(sort=="endcome"){
			selectSQL +="AND "+ENDCOME_DATE+"> (p.end_date-sysdate )";
			selectSQL +=" ORDER BY p.end_date ASC";

		//시작일 종료일
		}else if(sort=="startDate") {
			selectSQL +=" ORDER BY p.start_date ASC";
			
			
		}else if(sort=="endDate") {
			selectSQL +=" ORDER BY p.end_date ASC";
			
		}else if(sort==null){
		}
		else {
				throw new FindException("sort 값이 잘못되었습니다.");
			}
		return selectSQL;

	}
	
	public static void main(String[] args) {
		ProjectDAOOracle dao = new ProjectDAOOracle();
		try {
			System.out.println("신규 프로젝트");
			List<Project> a =dao.findByRequestData(null, "onGoing", null, null, "publishedAt", null,null);
			for (Project p : a) {
				System.out.println(p.getProjectNo());
				System.out.println(p.getLongTitle());
				Users u = p.getMaker(); 
				System.out.println(u.getUserName());
				System.out.println();
			}
		
			System.out.println("공개예쩡 프로젝트");
			List<Project> b =dao.findByRequestData(null, "prelaunching", null, null, "popular", null,null);
			for (Project p : b) {
				System.out.println(p.getProjectNo());
				System.out.println(p.getLongTitle());
				Users u = p.getMaker(); 
				System.out.println(u.getUserName());
				System.out.println();
			}

			System.out.println("마감임박 프로젝트");
			List<Project> c =dao.findByRequestData(null, "onGoing", null, null, "endcome", null,null);
			for (Project p : c) {
				System.out.println(p.getProjectNo());
				System.out.println(p.getLongTitle());
				Users u = p.getMaker(); 
				System.out.println(u.getUserName());
				System.out.println();
			}
			
			
			System.out.println("인기 프로젝트");
			List<Project> d =dao.findByRequestData(null, "onGoing", null, null, "popular", null,null);
			
			for (Project p : d) {
				System.out.println(p.getProjectNo());
				System.out.println(p.getLongTitle());
				Users u = p.getMaker(); 
				System.out.println(u.getUserName());
				System.out.println();
			}

			System.out.println("주목할만한 프로젝트");
			List<Project> e =dao.findByRequestData(null, "onGoing", null, "3", null, null,null);
			for (Project p : e) {
				System.out.println(p.getProjectNo());
				System.out.println(p.getLongTitle());
				Users u = p.getMaker(); 
				System.out.println(u.getUserName());
				System.out.println();
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
