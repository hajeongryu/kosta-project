package com.team.project.service;

import java.util.ArrayList;
import java.util.List;

import com.team.exception.FindException;
import com.team.project.dao.ProjectDAOOracle;
import com.team.project.vo.Project;
import com.team.project.vo.Reward;
import com.team.user.vo.Users;

public class ProjectService {

	private ProjectDAOOracle dao;
	
	private static ProjectService service = new ProjectService();

	public static ProjectService getInstance() {
		return service;
	}
	
	private ProjectService() {
	};
	
	
	public List<Project> getProjects(String category,
							String ongoing,
							String editorPick,
							String achiveRate,
							String sort,
							String rowCount,
							String loginedUserNo) throws FindException{
		
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(category, ongoing, editorPick, achiveRate, sort, rowCount, loginedUserNo);
				return findedProjects;
	}
	
	

	public List<Project> getAdProjects(int projectNo1, int projectNo2, int projectNo3 ) throws FindException {
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects = new ArrayList<Project>();
		Project p1 =dao.findByProjectNo(projectNo1);
		Project p2 =dao.findByProjectNo(projectNo2);
		Project p3 =dao.findByProjectNo(projectNo3);
		
		findedProjects.add(p1);
		findedProjects.add(p2);
		findedProjects.add(p3);

		
		return findedProjects;
	}
	
	
	
	public List<Project> getAttentionProject(String loginedUserNo) throws FindException{
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(null, "onGoing", null, "3", null, null,loginedUserNo);
		return findedProjects;
	}
	
	

	public List<Project> getPopularProject(String loginedUserNo) throws FindException{
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects=dao.findByRequestData(null, "onGoing", null, null, "popular", null,loginedUserNo);
		return findedProjects;
	}

	
	
	public List<Project> getEndcomeProject(String loginedUserNo) throws FindException{
	
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(null, "onGoing", null, null, "endcome", null,loginedUserNo);
		return findedProjects;
	}
	
	
	
	public List<Project> getReleaseProject(String loginedUserNo) throws FindException{
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(null, "prelaunching", null, null, "popular", null,loginedUserNo);
		return findedProjects;
	}
	
	
	
	public List<Project> getNewProject(String loginedUserNo) throws FindException{
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(null, "onGoing", null, null, "publishedAt", null,loginedUserNo);
		return findedProjects;
	}
	
	
	public Project findByProjectNo(String inProjectNo) throws FindException{
		dao = ProjectDAOOracle.getInstance();
		return dao.findByProjectNo(Integer.parseInt(inProjectNo));
	}
	
	
	public List<Reward> findReward(String inProjectNo) throws FindException{
		dao = ProjectDAOOracle.getInstance();
		return dao.findReward(Integer.parseInt(inProjectNo));
		
	}
	
	public List<Project> findByUserNo(String inUserNo) throws FindException{
		dao = ProjectDAOOracle.getInstance();
		return dao.findByUserNo(Integer.parseInt(inUserNo));
	}
	
	public static void main(String[] args) {
		ProjectService service1 =ProjectService.getInstance();
		try {
			List<Project> list=null;
			
			for (int i =0; i<6; i++) {

				if(i==0) {
					System.out.println(">??????????????? ??????");
					list =service1.getAdProjects(4, 5, 3); //??????
				}else if(i==1) {
					System.out.println(">?????? ????????????");
					list =service1.getPopularProject(null); //??????

				}else if(i==2) {
					System.out.println(">???????????? ????????????");
					list =service1.getEndcomeProject(null); //??????

				}else if(i==3) {
					System.out.println(">???????????? ????????????");
					list =service1.getReleaseProject("1");//??????

				}else if(i==4) {
					System.out.println(">?????? ????????????");
					list =service1.getNewProject(null); //??????

				}else if(i==5) {
				System.out.println(">????????? ?????? ????????????");
					list =service1.getAttentionProject(null); //??????
				}else if(i==6) {
					
				}
				
				for(Project p : list) {
					System.out.println("=====================");
					System.out.println(p.getProjectNo());
					System.out.println(p.getLongTitle());
					System.out.println("????????? ??????"+p.isLoginedUserProjectInterest());

					Users u =p.getMaker();
					System.out.println(u.getUserName());
					System.out.println("=====================");
				}
				System.out.println();
				System.out.println();
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
