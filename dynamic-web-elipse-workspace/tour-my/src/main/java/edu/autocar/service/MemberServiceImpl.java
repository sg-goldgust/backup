package edu.autocar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.autocar.dao.MemberDao;
import edu.autocar.dao.SHA256Util;
import edu.autocar.domain.Board.Member;
import edu.autocar.domain.Board.PageInfo;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemberServiceImpl implements MemberService {

	final static private int PER_PAGE_COUNT = 10;

	@Autowired
	MemberDao dao;

	@Autowired
	AvataService avataService;

	@Override
	public PageInfo<Member> getList(int page) throws Exception {
		int start = (page - 1) * PER_PAGE_COUNT;
		int end = start + PER_PAGE_COUNT;
		int totalCount = dao.count();
		List<Member> list = dao.getPage(start, end);
		// TODO Auto-generated method stub
		return new PageInfo<Member>(totalCount, (int) Math.ceil(totalCount / (double) PER_PAGE_COUNT), page,
				PER_PAGE_COUNT, list);
	}

	@Override
	public Member getMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(userId);
	}

	@Override
	@Transactional
	public void create(Member member, MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		String salt = SHA256Util.generateSalt();
		String encPassword = SHA256Util.getEncrypt(member.getPassword(), salt);
		member.setSalt(salt);
		member.setPassword(encPassword);
		dao.insert(member);
		avataService.create(member.getUserId(), file);
	}

	@Override
	@Transactional
	public boolean delete(String userId, String password) throws Exception {
		if (!checkAdminPassword(password))
			return false;
		return dao.delete(userId, password) == 1;
	}

	@Transactional
	@Override
	public boolean updateByAdmin(Member member, MultipartFile file) throws Exception {
		if (!checkAdminPassword(member.getPassword()))
			return false;
		if (dao.updateByAdmin(member) != 1)
			return false; // 아바타 수정
		avataService.update(member.getUserId(), file);
		return true;

	}

	private boolean checkAdminPassword(String password) throws Exception {
		Member admin = dao.findById("admin");
		String adminPassword = admin.getPassword();
		password = SHA256Util.getEncrypt(password, // 입력받은 비밀번호
				admin.getSalt()); // admin의 salt
		return adminPassword.equals(password);
	}

	@Override
	public Member checkPassword(String userId, String password) throws Exception {
		Member user = dao.findById(userId);
		if (user != null) {
			// 사용자 ID가 존재하는 경우
			password = SHA256Util.getEncrypt(password, user.getSalt());
			if (password.equals(user.getPassword()))
				return user;
		}
		// ID가 없거나 비밀번호가 다른 경우
		return null;
	}

	@Transactional
	@Override
	public boolean update(Member member, MultipartFile file) throws Exception {
		/*
		 * if (checkPassword(member.getUserId(), member.getPassword()) == null) return
		 * false; return dao.update(member) == 1;
		 */
		if (checkPassword(member.getUserId(), member.getPassword()) == null)
			return false;
		if (dao.update(member) == 0)
			return false;
		return avataService.update(member.getUserId(), file);
	}

}
