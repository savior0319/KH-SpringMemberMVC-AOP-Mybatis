package org.kh.member.model.dao;

import org.kh.member.model.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;

public interface MemberDAO {

	int updateMember(SqlSessionTemplate sqlSession, MemberVO mv);

	int insertMember(SqlSessionTemplate sqlSession, MemberVO mv);

	int withdrawMember(SqlSessionTemplate jdbc, String userId);

	Object allMember(SqlSessionTemplate sqlSession);

	MemberVO selectOneMember(SqlSessionTemplate sqlSession, MemberVO mv);

	MemberVO selectOneMemberNoEncrypt(SqlSessionTemplate sqlSession, MemberVO mv);

}
