package com.example.ezentour.model.user.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.ezentour.controller.HotelController;
import com.example.ezentour.model.user.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {
	private static final Logger LOG = LoggerFactory.getLogger(HotelController.class);
	@Inject
	SqlSession sqlSession;
	Date date;
	CartDTO cartDto = new CartDTO(0,"","" ,"");
	
	@Override
	public void insertCartList(int h_no,String h_m_id,String checkInDate,String checkOutDate) {
		System.out.println("여기: "+ checkOutDate);
		cartDto.setS_h_no(h_no);
		cartDto.setS_m_id(h_m_id);
		cartDto.setS_checkin(checkInDate);
		cartDto.setC_checkout(checkOutDate);
		System.out.println("cartDtO(CartDAOImpl) :" + cartDto.toString());
		sqlSession.insert("user.cart_insert",cartDto);
	}
	@Override
	public List<CartDTO> viewCartList(String m_id,int startPage,int endPage){
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("m_id", m_id);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		LOG.info("viewCartListCheck(cartDAOImpl)"+map.get("startPage"));
		
		List<CartDTO> list= sqlSession.selectList("user.cart_innerJoinView",map);
		return list;
	}
	@Override
	public void cartDelete(int s_no) {
		LOG.info("deleteCheck(CartDAOImpl : " + s_no);
		sqlSession.delete("user.cart_delete", s_no);
	}
	
	@Override
	public int  cartListCount() {
		int count = sqlSession.selectOne("user.cart_count");
		LOG.info("cartListCount(CartDAOImpl) : " + count);
		return count; 
	}
}
