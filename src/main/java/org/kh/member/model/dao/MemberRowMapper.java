package org.kh.member.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.member.model.vo.MemberVO;
import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<Object> {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO m = new MemberVO();
		m.setUserId(rs.getString("USER_ID"));
		m.setUserPw(rs.getString("USER_PWD"));
		m.setUserName(rs.getString("USER_NAME"));
		m.setPhone(rs.getString("USER_PHONE"));
		return m;
	}

}
