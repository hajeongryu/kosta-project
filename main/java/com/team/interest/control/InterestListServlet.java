package com.team.interest.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.team.exception.FindException;
import com.team.interest.service.InterestService;
import com.team.user.vo.Interest;
import com.team.user.vo.Users;

/**
 * 헤더 하트 또는 관심프로젝트 또는 관심프로젝트 내부에서 좋아한 눌렀을때 요청
 * @author 류하정
 *
 */
@WebServlet("/interestlist")
public class InterestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InterestService service = InterestService.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션 값 얻기
		HttpSession session = request.getSession();
		Users u = (Users)session.getAttribute("loginInfo");
		int userNo = u.getUserNo();
		
		String path = "./jsp/profile/interestprojectresult.jsp";
		List<Interest> list = new ArrayList<>();
		int interCnt = 0;
		int alarmCnt = 0;
		
		if(u != null) {
			try {
				list = service.myInterestProjects(userNo);
			} catch (FindException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("list", list);
		
		// 좋아한, 알림신청 개수
		try {
			interCnt = service.countInterestProjects(userNo);
			alarmCnt = service.countAlarmProjects(userNo);
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("interCnt", interCnt);
		request.setAttribute("alarmCnt", alarmCnt);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
