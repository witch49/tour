package com.example.ezentour.service.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.ezentour.model.board.dao.BoardCommentDAO;
import com.example.ezentour.model.board.dto.BoardCommentDTO;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {
	private static final Logger LOG = LoggerFactory.getLogger(BoardCommentServiceImpl.class);
	
	int randomNum=0;
	String randomColor=null;
	
	@Inject
	BoardCommentDAO bCommentDao;
	
	@Override
	public void commetInsert(String c_m_id,String comment, int c_b_no) {
		LOG.info("BoardCommetImplCheck :" +comment+ "," +c_m_id +","+c_b_no);
		bCommentDao.commetInsert(c_m_id, comment, c_b_no);
	}
	
	@Override
	public List<BoardCommentDTO> commentList(int b_no){
		return bCommentDao.commentList(b_no);
	}
	@Override
	public void commentDelete(int c_no) {
		bCommentDao.commentDelete(c_no);
	}
	
}
