package com.team.order.control;

import java.io.IOException;
import java.util.List;

import com.team.exception.FindException;
import com.team.order.service.OrderService;
import com.team.order.vo.Order;
import com.team.project.vo.Project;
import com.team.project.vo.Reward;
import com.team.user.service.AddrService;
import com.team.user.service.CardService;
import com.team.user.vo.Address;
import com.team.user.vo.Card;
import com.team.user.vo.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderAdd
 */
@WebServlet("/orderadd")
public class OrderAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CardService cardService = CardService.getInstance();
		AddrService addrService = AddrService.getInstance();

		HttpSession session = request.getSession();
		Users loginedUserObj = (Users) session.getAttribute("loginInfo");

		Order newOrder = new Order();
		
		String totalPrice= (String) request.getParameter("totalPrice");
		String rewardNo= (String) request.getParameter("rewardNo");
		String projectNo= (String ) request.getParameter("projectNo");
		
		
		System.out.println("구매금액"+totalPrice);
		System.out.println("구매한 상품 번호"+rewardNo);
		System.out.println("구매한 프로젝트 번호"+projectNo);


		
		String path="";
		//배송지 정보 , 카드정보 얻기
		
		if( loginedUserObj != null){
			//유저추가

			System.out.println("[OrderAddServlet] 로인한 유저의 유저번호 : "+loginedUserObj.getUserNo());

			List<Card> cardList =null;
			List<Address> addrList = null;

			try {
				cardList= cardService.findByUserNo(loginedUserObj.getUserNo());
				addrList= addrService.findByUserNo(loginedUserObj.getUserNo());
				
				//1.유저 정보추가
				newOrder.setOrderUser(loginedUserObj);
				
				
				//2.카드정보 추가
				for(Card card : cardList) {
					if (card.getDefaultCard().equals("1")) {
						//결제카드 선택
						newOrder.setCard(card);
					}
				}
				if(newOrder.getCard() == null) {
					throw new FindException("기본 설정된 카드가 없습니다!");
				}
				
				
				
				//3.배송지 정보 추가
				for(Address addr : addrList) {
					if(addr.getDefaultAddress().equals("1")) {
						//결제 주소 선택
						newOrder.setAddress(addr);
					}
				}
				if(newOrder.getAddress() == null) {
					throw new FindException("기본 설정된 주소지가 없습니다!");
				}
				
				
				
				//4.프로젝트 번호 추가
				if( projectNo != null) {
					System.out.println(projectNo);
					Project p = new Project();
					p.setProjectNo(Integer.parseInt(projectNo));
					newOrder.setProject(p);

				}else {
					throw new FindException("없는 프로젝트 번호");
				}

				
					
				//5.상품 번호
				if(rewardNo != null ) {
					Reward r = new Reward();
					r.setRewardNo(Integer.parseInt(rewardNo));
					newOrder.setReward(r);
				}else {
					throw new FindException("없는 상품정보(rewardNo)");
				}
		
				//6.상품가격 추가 + 7.후원금 기능 미구현(일단 1000으로)
				if(totalPrice != null) {
					newOrder.setTotalPrice(Integer.parseInt(totalPrice));
					newOrder.setExtraPrice(1000);
				}
		
				//8결제상황
				newOrder.setPaymentResult("진행중");
				
				
				System.out.println("1번"+newOrder.getOrderUser().getUserNo());
				 System.out.println("2번"+newOrder.getExtraPrice());
				 System.out.println("3번"+newOrder.getTotalPrice());
				 System.out.println("4번"+newOrder.getPaymentResult());
				 System.out.println("5번"+newOrder.getReward().getRewardNo());
				 System.out.println("6번"+newOrder.getAddress().getAddressNo());
				 System.out.println("7번"+newOrder.getCard().getCardNo());
				 System.out.println("8번"+newOrder.getProject().getProjectNo());
				
				OrderService service= OrderService.getInstance();
				service.add(newOrder);
				path ="";
			} catch (NumberFormatException e) {
				e.printStackTrace();
				path="";
			} catch (FindException e) {
				e.printStackTrace();
				path="";
			}
			
		}else {
			System.out.println("로그인 안한상태로 OrderAddServelt접근");
			path="/";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		
	
		
	
		

			
		
	}

}
