package com.team.user.service;

import java.sql.Date;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.user.dao.CardDAOOracle;
import com.team.user.dao.UserDAOOracle;
import com.team.user.vo.Card;
import com.team.user.vo.Users;

public class CardService {
	private CardDAOOracle dao = CardDAOOracle.getInstance();
	private static CardService service = new CardService();
	private CardService() {}
	public static CardService getInstance() {
		return service;
	}
	private UserDAOOracle userDao = UserDAOOracle.getInstance(); 
	
	
	public void addCardService(int userNo, String cardNum, Date cardValidDate, String cardPwd, 
								String cardOwnerBirth, String defaultCard) throws AddException {
		//카드중복 확인은 2차에서 api 사용하면 해결되는 것
		Users u = null;
		try {
			u = userDao.findByUserNo(userNo);
		} catch (FindException e1) {
			e1.printStackTrace();
		}
		Card c = new Card(u, cardNum, cardValidDate, cardPwd, cardOwnerBirth, defaultCard);
		try {
			dao.addCard(c);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyCardService(int cardNo) throws ModifyException {
		Card c = null;
		try {
			c = dao.findByCardNo(cardNo);
			if(c == null) {
				throw new ModifyException("카드가 존재하지 않습니다");
			}
			dao.modifyCard(c);
		} catch (FindException | ModifyException e) {
			e.printStackTrace();
		}
	}
	
	public void removeCardService(int cardNo) throws RemoveException {
		Card c = null;
		try {
			c = dao.findByCardNo(cardNo);
			if(c == null) {
				throw new RemoveException("카드가 존재하지 않습니다");
			}
			dao.removeCard(c);
		} catch (FindException | RemoveException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//addCardService test
//		Date d = Date.valueOf("2020-02-02");
//		try {
//			service.addCardService(5, "1234123412341234", d, "4444", "20220101", "0");
//		} catch (AddException e) {
//			e.printStackTrace();
//		}
		
		
		//modifyCardService test
//		try {
//			service.modifyCardService(11);
//		} catch (ModifyException e) {
//			e.printStackTrace();
//		}
		
		//removeCardService test
//		try {
//			service.removeCardService(14);
//		} catch (RemoveException e) {
//			e.printStackTrace();
//		}
		
	}
}
