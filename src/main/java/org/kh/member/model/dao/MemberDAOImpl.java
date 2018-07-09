package org.kh.member.model.dao;

import java.util.List;

import org.kh.member.model.vo.MemberVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	public MemberDAOImpl() {
	}

	@Override
	public MemberVO selectOneMember(JdbcTemplate jdbc, MemberVO mv) {

		String query = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";

		// query 메소드는 인자값 2개 혹은 3개
		// 2개 -> query, RowMapper
		// 3개 -> query, query parameter, RowMapper
		// query : SQL 구문
		// RowMapper : 작동한 쿼리문에 대한 결과값을 처리하는것이 명시된 객체
		// query parameter : 쿼리문에 ? 가 있을 경우에 사용되는 인자 값

		// query parameter (Object 배열)
		Object[] params = { mv.getUserId(), mv.getUserPw() };

		List<Object> list = jdbc.query(query, params, new MemberRowMapper());

		if (!list.isEmpty()) {
			return (MemberVO) list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public MemberVO selectOneMemberNoEncrypt(JdbcTemplate jdbc, MemberVO mv) {

		System.out.println("DAO : " + mv.getUserPw());

		String query = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";

		// query 메소드는 인자값 2개 혹은 3개
		// 2개 -> query, RowMapper
		// 3개 -> query, query parameter, RowMapper
		// query : SQL 구문
		// RowMapper : 작동한 쿼리문에 대한 결과값을 처리하는것이 명시된 객체
		// query parameter : 쿼리문에 ? 가 있을 경우에 사용되는 인자 값

		// query parameter (Object 배열)
		Object[] params = { mv.getUserId(), mv.getUserPw() };

		List<Object> list = jdbc.query(query, params, new MemberRowMapper());

		if (!list.isEmpty()) {
			return (MemberVO) list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public int updateMember(JdbcTemplate jdbc, MemberVO mv) {

		String query = "UPDATE MEMBER SET USER_PWD = ?, USER_PHONE = ? WHERE USER_ID =?";

		Object[] params = { mv.getUserPw(), mv.getPhone(), mv.getUserId() };
		int result = jdbc.update(query, params);

		return result;
	}

	@Override
	public int insertMember(JdbcTemplate jdbc, MemberVO mv) {

		String query = "INSERT INTO MEMBER VALUES(?, ?, ?, ?)";

		Object[] params = { mv.getUserId(), mv.getUserPw(), mv.getUserName(), mv.getPhone() };

		int result = jdbc.update(query, params);

		return result;
	}

	@Override
	public int withdrawMember(JdbcTemplate jdbc, String userId) {

		String query = "DELETE FROM MEMBER WHERE USER_ID = ?";

		Object[] params = { userId };

		int result = jdbc.update(query, params);

		return result;
	}

	@Override
	public List<Object> allMember(JdbcTemplate jdbc) {

		String query = "SELECT * FROM MEMBER";
		List<Object> list = jdbc.query(query, new MemberRowMapper());

		return list;
	}

}
