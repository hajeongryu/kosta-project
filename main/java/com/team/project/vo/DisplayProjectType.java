package com.team.project.vo;

import java.util.Date;//유틸로 임포트

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
	public int support;
	public String projectImage;
	
	
	public DisplayProjectType(int projectNo, String cateogryName, String userName,
								 String longTitle, int target_price, int sum_price,
								 Date endDate, int spoortCnt, String projectImage) {

		this.projectNo = projectNo;
		this.cateogryName = cateogryName;
		this.userName = userName;
		this.longTitle = longTitle;
		this.target_price = target_price;
		this.sum_price = sum_price;
		this.endDate = endDate;
		this.support= spoortCnt;
		this.projectImage = projectImage;
	}


	
	
	@Override
	public String toString() {
		return "DisplayProjectType [projectNo=" + projectNo + ", cateogryName=" + cateogryName + ", userName="
				+ userName + ", longTitle=" + longTitle + ", target_price=" + target_price + ", sum_price=" + sum_price
				+ ", endDate=" + endDate + ", spoortCnt=" + support+ ", projectImage=" + projectImage + "]";
	}


	}

