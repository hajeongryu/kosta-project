package com.team.project.control;

import java.io.IOException;
import java.util.List;

import com.team.community.service.CommentService;
import com.team.community.service.PostService;
import com.team.exception.FindException;
import com.team.project.service.ProjectService;
import com.team.project.vo.Comments;
import com.team.project.vo.Community;
import com.team.project.vo.Project;
import com.team.project.vo.Reward;
import com.team.user.vo.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/projectdetail")
public class ProjectDetailServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PostService postService = PostService.getInstance();
	CommentService cmtService = CommentService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String loginedUserNo =null;

		Users u = (Users)session.getAttribute("loginInfo");
		if(u != null) {
			loginedUserNo = u.getUserNo()+"";
		}
		System.out.println("[projectDetailSelvert] 로그인한 유저의 유저번호 : "+loginedUserNo);

		String projectNo = request.getParameter("projectNo");
		ProjectService projectService = ProjectService.getInstance();


		try {
			//선물정보
			Project p = projectService.findByProjectNo(projectNo);
			request.setAttribute("findedProject", p);
			List<Reward> rewardList = projectService.findReward(projectNo);
			request.setAttribute("findedProjectReward", rewardList);

			//커뮤니티(post)정보
			List<Community> post = postService.findByProjectNo(Integer.parseInt(projectNo));
			
			//댓글
			for (Community community : post) {
				List<Comments> cmt = cmtService.findByPostNo(community.getPostNo());
				community.setComments(cmt);				
			}
			request.setAttribute("findedPost", post);
		


		} catch (FindException e) {
			e.printStackTrace();
		}

		String path="./jsp/projectdetailpage/detail_head.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
