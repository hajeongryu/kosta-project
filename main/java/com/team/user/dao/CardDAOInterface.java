package com.team.user.dao;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.user.vo.Card;

public interface CardDAOInterface {
	
	/**
	 * 회원번호에 해당하는 고객이 등록한 카드 리스트를 반환한다
	 * @param userNo 
	 * @return 
	 * @throws FindException
	 */
	public List<Card> findByUserNo(int userNo) throws FindException;
	
	/**
	 * 카드를 추가한다
	 * @param card
	 * @throws AddException
	 */
	public void addCard(Card card) throws AddException;
	
	/**
	 * 등록한 카드를 기본결제수단으로 바꾸고 나머지 카드는 기본결제수단에서 제외한다
	 * (2차에서 api 사용하면 검증된 카드정보를 불러오기 때문에 추가 수정사항이 없다)
	 * @param card
	 * @throws ModifyException
	 */
	public void modifyCard(Card card) throws ModifyException;
	
	/**
	 * 등록한 카드를 삭제한다
	 * @param card
	 * @throws RemoveException
	 */
	public void removeCard(Card card) throws RemoveException;
	
	/**
	 * 카드번호에 해당하는 카드를 반환한다
	 * @param cardNo
	 * @return
	 * @throws FindException
	 */
	public Card findByCardNo(int cardNo) throws FindException;
}
