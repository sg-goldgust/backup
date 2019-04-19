package edu.autocar.service;

import org.springframework.web.multipart.MultipartFile;

import edu.autocar.domain.Board.Member;
import edu.autocar.domain.Board.PageInfo;

public interface MemberService {
	PageInfo<Member> getList(int page) throws Exception;
	
	void create(Member member , MultipartFile file) throws Exception;

	boolean update(Member member , MultipartFile file) throws Exception;

	boolean delete(String userId, String password) throws Exception;
	
	Member getMember(String id) throws Exception;
	
	boolean updateByAdmin(Member member , MultipartFile file) throws Exception;
	
	public Member checkPassword(String userId, String password) throws Exception;
	
	
}
