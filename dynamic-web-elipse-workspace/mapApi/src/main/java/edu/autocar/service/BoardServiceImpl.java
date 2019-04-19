package edu.autocar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.autocar.dao.BoardDao;
import edu.autocar.domain.Board.Board;
import edu.autocar.domain.Board.PageInfo;
import lombok.extern.slf4j.Slf4j;
@Repository // run time 에러가 아닌 sql error도 처리해준다.
@Slf4j
public class BoardServiceImpl implements BoardService {
	//private List<Board> boardList;
	final static private int PER_PAGE_COUNT = 10;
	
	@Autowired
	BoardDao dao;
	
//	int maxId=0;
//	
//	public BoardServiceImpl() {
//		boardList = Collections.synchronizedList(new LinkedList<>());
//		for(maxId = 1; maxId <=45 ; maxId ++) {
//			boardList.add(0,new Board(maxId));
//		}
//	}
	
	
	
	
	
	
	@Override
	public PageInfo<Board> getPage(int page) throws Exception {
		
		int start = (page-1)*PER_PAGE_COUNT;
		int end = start + PER_PAGE_COUNT;
		
		int totalCount = dao.count();
		List<Board> list = dao.getPage(start, end);
		/*if(end > totalCount) {
			end = totalCount;
		}
		for(int i = start; i<end; i++) {
			list.add(boardList.get(i));
		}*/
		return new PageInfo<Board>(
				totalCount,
				(int)Math.ceil(totalCount/(double)PER_PAGE_COUNT),
				page, PER_PAGE_COUNT, list);
				
	}
	@Override
	@Transactional
	public Board getBoard(int boardId) throws Exception {
		
		/*for(Board board : boardList) {
			if(board.getBoardId()==boardId) {
				int cnt = board.getReadCnt();
				board.setReadCnt(++cnt);
				return board;
			}
		}
		// TODO Auto-generated method stub
		return null;*/
		dao.increaseReadCnt(boardId); // 조회수 증가
		return dao.findById(boardId);
	}

	@Override
	@Transactional
	public void create(Board board) throws Exception {
		/*board.setBoardId(maxId);
		board.setRegDate(new Date());
		board.setUpdateDate(new Date());
		maxId++;
		
		boardList.add(0,board);*/
		dao.insert(board);
		//throw new Exception("계시글 등록 실패");
	}

	@Override
	@Transactional
	public boolean update(Board board) throws Exception {
		/*for(Board b : boardList) {
			if(b.getBoardId() == board.getBoardId()) {
				if(b.getPassword().contentEquals(board.getPassword())) {
					b.setTitle(board.getTitle());
					b.setWriter(board.getWriter());
					b.setContent(board.getContent());
					b.setUpdateDate(new Date());
					return true;
				} else {
					return false;
				}
			}
		}
		return false;*/
	
		return dao.update(board) == 1;
	}

	@Override
	@Transactional
	public boolean delete(int boardId, String password) throws Exception {
		/*or(int ix=0; ix<boardList.size(); ix++) {
			Board board = boardList.get(ix);
			if(board.getBoardId()==boardId) {
				if(board.getPassword().equals(password)) {
					boardList.remove(ix);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;*/
		return dao.delete(boardId, password) == 1;
	}

}
