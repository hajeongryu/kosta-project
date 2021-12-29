package com.team.user.service;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.user.dao.UserDAOOracle;
import com.team.user.vo.Users;

public class UserService {
	private UserDAOOracle dao = UserDAOOracle.getInstance();
	private static UserService service = new UserService();
	private UserService() {}
	public static UserService getInstance() {
		return service;
	}
	
	public Users findByUserNo(int userNo) throws FindException {
		Users u = dao.findByUserNo(userNo);
		return u;
	}
	
	
	public Users login(String userId, String userPwd) throws FindException {
		try {
			Users u = dao.findByUserId(userId);
			//userId(이메일)로 검색한 값이 null이 아니며 DB의 비밀번호와 request 비밀번호가 일치하는지
			if(u != null && u.getUserPwd().equals(userPwd)) {
				//일치하는 경우에도 계정상태가 탈퇴라면 로그인 불가능
				if (u.getUserStatus().equals("0")) {
					throw new FindException("탈퇴한 계정입니다");
				} else {
					return u;
				}
			}
			throw new FindException();
		} catch (FindException e) {
			throw new FindException("로그인 실패");
		}
	}
	
	
	public void signup(String userName, String userId, String userPwd) throws AddException {
		try {
			Users u = dao.findByUserId(userId);
			//userId(이메일)로 검색한 결과가 null이라면 중복이 아니므로 생성
			if(u == null) {
				Users u2 = new Users(userName, userId, userPwd);
				dao.addUser(u2);
			} else {
				throw new AddException("이미 존재하는 아이디입니다");
			}
		} catch (FindException e) {

		}
	}
	
	
	public void profileSet(int userNo, String userImage, String userName, 
							String userUrl, String userIntroduction, String userWebsite) throws ModifyException {
		try {
			//회원번호로 검색한 기존 회원정보 객체
			Users u = dao.findByUserNo(userNo);
			//request 값으로 수정된 회원정보 객체
			Users u2 = new Users(u.getUserNo(), u.getUserRole(), u.getUserId(), userName, u.getUserPwd(), u.getUserSignupDate(), 
					u.getUserStatus(), userImage, u.getUserPhone(), userIntroduction, userWebsite, userUrl );
			//수정된 회원정보 객체로 DB 업데이트
			dao.modifyProfile(u2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void accountSet(int userNo, String userId, String userPwd, String userPhone) throws ModifyException {
		try {
			Users u = dao.findByUserNo(userNo);
			//아이디 중복 확인
			if (dao.findByUserId(userId) != null) {
				throw new ModifyException("중복된 ID입니다");
			} else {
				Users u2 = new Users(u.getUserNo(), u.getUserRole(), userId, u.getUserName(), userPwd, u.getUserSignupDate(),
					u.getUserStatus(), u.getUserImage(), userPhone, u.getUserIntroduction(), u.getUserWebsite(), u.getUserUrl());
				dao.modifyInfo(u2);
			}
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
	
	public void withdrawal(int userNo) throws ModifyException {
		dao.modifyStatus(userNo);
	}
	
	
	public static void main(String[] args) {
		//login test
//		try {
//			Users u = service.login("testid", "p1");
//			System.out.println(u.getUserName() + ", " + u.getUserNo());
//		} catch (FindException e1) {
//			e1.printStackTrace();
//		}

		//signup test
//		try {
//			service.signup("이름", "id1", "비밀번호1");
//		} catch (AddException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//profileSet test
//		try {
//			service.profileSet(7, "imageUrl1111", "rholl", "userUrl222222", "testing", "kosta");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//accountSet test
//		try {
//			service.accountSet(10, "id1", "p0000", "xxxx");
//		} catch (ModifyException e) {
//			e.printStackTrace();
//		}
		
		//withdrawal test
//		try {
//			service.withdrawal(10);
//		} catch (ModifyException e) {
//			e.printStackTrace();
//		}
	}
}
