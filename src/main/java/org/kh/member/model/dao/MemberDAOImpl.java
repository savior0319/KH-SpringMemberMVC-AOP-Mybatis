package org.kh.member.model.dao;

import java.util.List;

import org.kh.member.model.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	public MemberDAOImpl() {
	}

	@Override
	public MemberVO selectOneMember(SqlSessionTemplate sqlSession, MemberVO mv) {
		return sqlSession.selectOne("member.selectOneMember", mv);
	}

	@Override
	public MemberVO selectOneMemberNoEncrypt(SqlSessionTemplate sqlSession, MemberVO mv) {
		return sqlSession.selectOne("member.selectOneMember", mv);
	}

	@Override
	public int updateMember(SqlSessionTemplate sqlSession, MemberVO mv) {
		int result = sqlSession.update("member.updateMember", mv);
		return result;
	}

	@Override
	public int insertMember(SqlSessionTemplate sqlSession, MemberVO mv) {
		int result = sqlSession.update("member.insertMember", mv);
		return result;
	}

	@Override
	public int withdrawMember(SqlSessionTemplate sqlSession, String userId) {
		int result = sqlSession.update("member.withdrawMember", userId);
		return result;
	}

	@Override
	public List<Object> allMember(SqlSessionTemplate sqlSession) {
		List<Object> list = sqlSession.selectList("member.allMember");
		return list;
	}

}
