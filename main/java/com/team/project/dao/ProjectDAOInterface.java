package com.team.project.dao;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.project.vo.Project;
import com.team.project.vo.Reward;

public interface ProjectDAOInterface {
	
	/**
	 * DB내의 모든 프로젝트들을 반환해 줍니다.
	 * @return
	 * @throws FindException 프로젝트가 없는 경우에 예외발생
	 */
	public List<Project> findAll() throws FindException;
	

	/**
	 * ProjectNo에 해당하는 프로젝트를 찾아서 반환해 줍니다.
	 * @param projectNo 프로젝트번호
	 * @return 
	 * @throws FindException 프로젝트가 없는 경우 예외발생
	 */
	public Project findByProjectNo(int projectNo) throws FindException;

	
	/**
	 * 프로젝트가 소유한 상품(판매되는 목록)들 을 반환해줍니다.
	 * @param projectNo
	 * @return
	 * @throws FindException
	 */
	public List<Reward> findReward(int projectNo) throws FindException;


	/**
	 * 해당 유저가 제작한 프로젝트들 을 반환해 줍니다.
	 * @param userNo
	 * @return
	 * @throws FindException
	 */
	public List<Project> findByUserNo(int userNo) throws FindException;

	
	/**
	 * Request값을 매개변수로 전달받아 요구사항에 맞는 게시글을 반환해 줍니다.
	 * null 값이 들어있을시 해당 정렬은 사용안함
	 * 
	 * 
	 * @param category (카테고리)  	          ="all"(전체) , "1"(보드게임) "2"(티알피지) 등등..
	 *										카테고리쪽에 null이 들어올시 자동으로 "all"전체로 처리
	 * 
	 * @param ongoing (진행상황)    		  = "onGoing"(진행중),  "confirm" , "prelaunching"공개예정
	 * @param editorPick (에디터 추천여부)     ="1"(에디터 추천) 
	 * @param achiveRate (달성률)   		  = "1" (75퍼이하 달성률),  "2" (75~100달성률),  "3" (100%이상 달성률)
	 * @param sort (정렬)                   = popular(인기순) publishedAt(최신순) pledges(후원순) amount(금액순) ended(마감 임박순),endDate,startDate
	 * @param rowCount (출력갯수)  			  = "1" 한개 , "2" 두개...  null일시(100개) 
	 * @param loginedUserNo (로그인한 유저가 좋아했는지 판단하는 용도)  ="1"(user_no 1이 이 프로젝트를 좋아했는지 loginedUserProjectInterest를 수정) 
	 * @return
	 * @throws FindException
	 */
	public List<Project> findByRequestData(String category, String ongoing, String editorPick, 
										String achiveRate, String sort, String rowCount , String loginedUserNo) throws FindException;
	
	

	
	public void add(Project project) throws AddException;
	public void modify(Project project) throws ModifyException;
	public void remove(int projectNo) throws RemoveException;
}