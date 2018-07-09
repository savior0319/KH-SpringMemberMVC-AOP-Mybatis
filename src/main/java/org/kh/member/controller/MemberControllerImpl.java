package org.kh.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberControllerImpl implements MemberController {

	@Autowired
	@Qualifier(value = "memberService")
	private MemberService memberService;

	@Override
	@RequestMapping(value = "/login.do")
	public String selectOneMember(HttpServletRequest request, @RequestParam String userId,
			@RequestParam String userPw) {

		// 1. 값 추출(request 어노테이션 방법)
		MemberVO mv = new MemberVO();
		mv.setUserId(userId);
		mv.setUserPw(userPw);

		// 2. 비즈니스 로직
		MemberVO m = memberService.selectOneMember(mv);

		// 로그인 세션
		HttpSession session = request.getSession();

		// 3. viewName 리턴
		// viewName을 처 할 때 주의할 점
		// viewName을 dispatcherServlet에게 돌려주고 자동으로
		// 처리 되도록 만들지만 DispatcherServlet에서는
		// 무조건 forward 방식을 사용함
		if (m != null) {
			session.setAttribute("member", m);
			// session.setAttribute("loc", "member/loginSuccess");
			return "member/loginSuccess";
		} else {
			// session.setAttribute("loc", "member/loginFailed");
			return "member/loginFailed";
		}
		// return "redirect:/location.do";
	}

	@Override
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		MemberVO mv = (MemberVO) session.getAttribute("member");

		if (mv != null) {
			session.invalidate();
			// viewResolver 없이 직접 경로로 이동 (redirect:/xxx.jsp);
			// webapp에 있는건 가능 webapp/WEB-INF에 있는건 반드시 viewResolver를 통해 접근해야 함
			return "redirect:/index.jsp";
			// return "member/logoutSuccess";
		} else {
			return "member/logutFail";
		}
	}

	@Override
	@RequestMapping(value = "/myinfo.do")
	public Object myInfo(HttpSession session) {

		MemberVO mv = (MemberVO) session.getAttribute("member");
		System.out.println("컨트롤러 비번  " +  mv.getUserPw());
		MemberVO m = memberService.selectOneMemberNoEncrypt(mv);
		
		ModelAndView view = new ModelAndView();

		if (m != null) {
			view.addObject("modelMember", m);
			view.setViewName("member/myInfo");
			return view;
		} else {
			view.setViewName("member/myInfoFail");
			return view;
		}
	}

	@Override
	@RequestMapping(value = "/mupdate.do")
	public String memberUpdate(MemberVO mv, HttpSession session) {

		// System.out.println(mv.getUserId());
		// System.out.println(mv.getUserPw());
		// System.out.println(mv.getUserName());
		// System.out.println(mv.getPhone());

		int result = memberService.updateMember(mv);

		if (result >= 1) {
			session.setAttribute("member", mv);
			/* return "redirect:/myinfo.do"; */
			return "member/memberUpdateSuccess";
		} else {
			return "member/memberUpdateFail";
		}
	}

	@Override
	@RequestMapping(value = "/signup.do")
	public String insertMember(MemberVO mv) {

		int result = memberService.insertMember(mv);

		if (result >= 1) {
			return "redirect:/";
		} else {
			return "member/memberUpdateFail";
		}
	}

	@Override
	@RequestMapping(value = "/signupredirect.do")
	public String signupRedirect() {
		return "member/signup";
	}

	@Override
	@RequestMapping(value = "/withdraw.do")
	public String withdrawMember(HttpSession session) {

		MemberVO vo = (MemberVO) session.getAttribute("member");

		String userId = vo.getUserId();

		System.out.println(userId);

		int result = memberService.withdrawMember(userId);

		if (result >= 1) {
			session.invalidate();
			return "redirect:/";
		} else {
			return "member/memberUpdateFail";
		}
	}

	@Override
	@RequestMapping(value = "/allmember.do")
	public Object allMember() {

		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) memberService.allMember();

		ModelAndView view = new ModelAndView();
		view.addObject("list", list);
		view.setViewName("member/allMemberList");
		return view;

	}
}
