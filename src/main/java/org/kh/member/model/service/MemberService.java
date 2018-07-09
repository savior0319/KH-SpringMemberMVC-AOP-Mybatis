package org.kh.member.model.service;

import org.kh.member.model.vo.MemberVO;

public interface MemberService {

	MemberVO selectOneMember(MemberVO mv);

	int updateMember(MemberVO mv);

	int insertMember(MemberVO mv);

	int withdrawMember(String userId);

	Object allMember();

	void logic();


	MemberVO selectOneMemberNoEncrypt(MemberVO mv);

}
