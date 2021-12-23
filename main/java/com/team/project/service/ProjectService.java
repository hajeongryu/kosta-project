package com.team.project.service;

import java.util.ArrayList;
import java.util.List;

import com.team.exception.FindException;
import com.team.project.dao.ProjectDAOOracle;
import com.team.project.vo.Project;
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
							String ongoning,
							String achiveRate,
							String sort,
							String rowCount) throws FindException{
		
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(category, category, ongoning, achiveRate, sort, rowCount);

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
	
	
	
	public List<Project> getAttentionProject() throws FindException{
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(null, "onGoing", null, "3", null, null);
		return findedProjects;
	}
	
	

	public List<Project> getPopularProject() throws FindException{
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects=dao.findByRequestData(null, "onGoing", null, null, "popular", null);
		return findedProjects;
	}

	
	
	public List<Project> getEndcomeProject() throws FindException{
	
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(null, "onGoing", null, null, "endcome", null);
		return findedProjects;
	}
	
	
	
	public List<Project> getReleaseProject() throws FindException{
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(null, "prelaunching", null, null, "popular", null);
		return findedProjects;
	}
	
	
	
	public List<Project> getNewProject() throws FindException{
		dao = ProjectDAOOracle.getInstance();
		List<Project> findedProjects =dao.findByRequestData(null, "onGoing", null, null, "publishedAt", null);
		return findedProjects;
	}
	
	
	public static void main(String[] args) {
		ProjectService service1 =ProjectService.getInstance();
		try {
			List<Project> list;
			//list =service1.getAdProjects(1, 2, 3);
			list =service1.getAttentionProject(); //잘됨
			//list =service1.getPopularProject(); //잘됨
			//list =service1.getEndcomeProject(); //잘됨
			//list =service1.getReleaseProject();//잘됨
			//list =service1.getNewProject(); //잘됨
			
			for(Project p : list) {
				System.out.println("=====================");
				System.out.println(p.getProjectNo());
				System.out.println(p.getLongTitle());
				System.out.println(p.getUserNo());

				Users u =p.getUser();
				System.out.println(u.getUserName());
				System.out.println("=====================");
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
