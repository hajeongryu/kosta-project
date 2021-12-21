package com.team.project.vo;

import java.sql.Date;

/*
 * PROJECT TABLE +
 * 		JOIN PROJECT_CAHNGE
 * 		JOIN USERS
 * 		JOIN CATEGORY
 * 		 
 * 
 *		 p.project_no"프로젝트 번호"
        ,category_name "카테고리 이름"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , sum_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        , support_cnt"후원자 수"
        , project_image "프로젝트 이미지" 
 * 
 * 
 */

public class DisplayProjectType {
	public int	projectNo;
	public String cateogryName;
	public String userName;
	public String longTitle;
	public int target_price;
	public int sum_price;
	public Date endDate;
	public int spoortCnt;
	public String projectImage;
	
}

