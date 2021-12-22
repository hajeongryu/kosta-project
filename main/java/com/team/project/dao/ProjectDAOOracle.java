package com.team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
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
		
	}
	
	
}
