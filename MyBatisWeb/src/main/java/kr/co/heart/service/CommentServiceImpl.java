package kr.co.heart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.dao.CommentDao;
import kr.co.heart.domain.CommentDto;

@Service
public class CommentServiceImpl implements CommentService {

	BoardDao boardDao;
	CommentDao commentDao;
	
	
	//@Autowired
	public CommentServiceImpl(BoardDao boardDao, CommentDao commentDao) {
		//super();
		this.boardDao = boardDao;
		this.commentDao = commentDao;
	}



	@Override
	public List<CommentDto> getList(Integer bno) throws Exception {
		
		//throw new Exception("test");
		return commentDao.selectAll(bno);
	}

}
