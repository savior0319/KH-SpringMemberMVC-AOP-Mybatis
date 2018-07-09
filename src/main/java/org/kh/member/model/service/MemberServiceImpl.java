package org.kh.member.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name = "memberDAO")
	private MemberDAOImpl memberDAO;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public MemberVO selectOneMember(MemberVO mv) {
		logic();
		MemberVO m = memberDAO.selectOneMember(jdbcTemplate, mv);
		return m;
	}

	@Override
	public int updateMember(MemberVO mv) {
		logic();
		int result = memberDAO.updateMember(jdbcTemplate, mv);
		return result;
	}

	@Override
	public int insertMember(MemberVO mv) {
		logic();
		int result = memberDAO.insertMember(jdbcTemplate, mv);
		return result;
	}

	@Override
	public int withdrawMember(String userId) {
		logic();
		int result = memberDAO.withdrawMember(jdbcTemplate, userId);
		return result;
	}

	@Override
	public List<Object> allMember() {
		logic();
		List<Object> list = (List<Object>) memberDAO.allMember(jdbcTemplate);
		return list;
	}

	@Override
	public void logic() {
		// System.out.println("비즈니스 로직 호출");
	}

	@Override
	public MemberVO selectOneMemberNoEncrypt(MemberVO mv) {
		
		System.out.println("Service : " + mv.getUserPw());
		MemberVO m = memberDAO.selectOneMemberNoEncrypt(jdbcTemplate, mv);
		
		System.out.println("DB 갔다옴 : " + m.getUserId());
		return m;
	}

}
