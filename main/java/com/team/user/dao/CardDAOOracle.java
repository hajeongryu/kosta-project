package com.team.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.sql.MyConnection;
import com.team.user.vo.Card;
import com.team.user.vo.Users;

public class CardDAOOracle implements CardDAOInterface {
	private static CardDAOOracle dao = new CardDAOOracle();
	private CardDAOOracle() {}
	public static CardDAOOracle getInstance() {
		return dao;
	}
	private UserDAOOracle userDao = UserDAOOracle.getInstance();
	
	@Override
	public List<Card> findByUserNo(int userNo) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSQL = "SELECT * FROM card WHERE user_no=?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			List<Card> cards = new ArrayList<>();
			while(rs.next()) {
				int cardNo = rs.getInt("card_no");
				String cardNum = rs.getString("card_num");
				Date cardValidDate = rs.getDate("card_valid_date");
				String cardPwd = rs.getString("card_pwd");
				String cardOwnerBirth = rs.getString("card_owner_birth");
				String defaultCard = rs.getString("default_card");
				
				Users u = userDao.findByUserNo(userNo);
				Card c = new Card(cardNo, u, cardNum, cardValidDate, cardPwd,
						cardOwnerBirth, defaultCard);
				cards.add(c);
			}
			if(cards.size() == 0) {
				return null;
			}
			return cards;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
	}

	
	@Override
	public void addCard(Card card) throws AddException {
		//서비스에서 디폴트 처리
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertDML = "INSERT INTO card (user_no, card_num, card_valid_date,"
				+ " card_pwd, card_owner_birth, default_card) VALUES (?,?,?,?,?,?)";
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(insertDML);
			pstmt.setInt(1, card.getUser().getUserNo());
			pstmt.setString(2, card.getCardNum());
			pstmt.setDate(3, card.getCardValidDate());
			pstmt.setString(4, card.getCardPwd());
			pstmt.setString(5, card.getCardOwnerBirth());
			pstmt.setString(6, card.getDefaultCard());
			pstmt.executeUpdate();
			if(card.getDefaultCard().equals("1")) {
				dao.modifyCard(card);
			}
			con.commit();
		} catch (SQLException | ModifyException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new AddException("카드 추가에 실패했습니다");
		} finally {
			MyConnection.close(pstmt, con);
		}
	}

	
	@Override
	public void modifyCard(Card card) throws ModifyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		List<Card> cards = new ArrayList<>();
		String selectSQL = "SELECT * FROM card WHERE user_no=?";
		String zeroUpdateDML ="UPDATE card SET default_card='0' WHERE user_no=?";
		String defaultUpdateDML = "UPDATE card SET default_card='1' WHERE card_no=?";
		try {
			con = MyConnection.getConnection();
			//중간에 발생하는 오류를 대비하여 오토커밋 방지
			con.setAutoCommit(false);
			//userNo으로 등록된 카드를 cards 리스트에 저장
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, card.getUser().getUserNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String defaultCard = rs.getString("default_card");
				Card c = new Card(card.getCardNo(), defaultCard);
				cards.add(c);
			}
			//userNo으로 등록된 카드 없으면 중단
			if(cards.size() == 0) {
				return;
			}
			//리스트에 저장된 카드들의 카드번호로 defaultCard 모두 0으로 변경
			pstmt2 = con.prepareStatement(zeroUpdateDML);
			pstmt2.setInt(1, card.getUser().getUserNo());
			pstmt2.executeUpdate();
			
			//기본결제수단으로 설정할 카드만 defaultCard 1로 변경
			pstmt3 = con.prepareStatement(defaultUpdateDML);
			pstmt3.setInt(1, card.getCardNo());
			pstmt3.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			MyConnection.close(pstmt, pstmt2, pstmt3, rs, con);
		}
		
	}

	
	@Override
	public void removeCard(Card card) throws RemoveException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String deleteDML= "DELETE FROM card WHERE card_no=?";
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(deleteDML);
			pstmt.setInt(1, card.getCardNo());
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			MyConnection.close(pstmt, con);
		}
		
	}
	@Override
	public Card findByCardNo(int cardNo) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSQL ="SELECT * FROM card WHERE card_no=?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, cardNo);
			rs = pstmt.executeQuery();

			rs.next();
			int userNo = rs.getInt("user_no");
			String cardNum = rs.getString("card_num");
			Date cardValidDate = rs.getDate("card_valid_date");
			String cardPwd = rs.getString("card_pwd");
			String cardOwnerBirth = rs.getString("card_owner_birth");
			String defaultCard = rs.getString("default_card");
			Users u = userDao.findByUserNo(userNo);
			Card c = new Card(cardNo, u, cardNum, cardValidDate, cardPwd, cardOwnerBirth, defaultCard);				
		
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException("카드를 찾지 못했습니다");
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		
	}
	

}
