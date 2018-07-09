package org.kh.member.model.dao;

import org.kh.member.model.vo.MemberVO;
import org.springframework.jdbc.core.JdbcTemplate;

public interface MemberDAO {

	MemberVO selectOneMember(JdbcTemplate jdbc, MemberVO mv);

	int updateMember(JdbcTemplate jdbcTemplate, MemberVO mv);

	int insertMember(JdbcTemplate jdbcTemplate, MemberVO mv);

	int withdrawMember(JdbcTemplate jdbc, String userId);

	Object allMember(JdbcTemplate jdbcTemplate);


	MemberVO selectOneMemberNoEncrypt(JdbcTemplate jdbc, MemberVO mv);

}
