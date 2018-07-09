package org.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.member.model.vo.MemberVO;

public interface MemberController {

	String selectOneMember(HttpServletRequest request, String userId, String userPw);

	String logout(HttpServletRequest request);

	Object myInfo(HttpSession session);

	String memberUpdate(MemberVO mv, HttpSession session);

	String signupRedirect();

	String insertMember(MemberVO mv);

	String withdrawMember(HttpSession session);

	Object allMember();

}
