package org.kh.member.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.kh.member.model.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MemberPasswordAdvice {

	public MemberPasswordAdvice() {
	}

	@Pointcut("execution(int org.kh.member.model.service.*ServiceImpl.insertMember(..))")
	public void encryptSHA256() {
	}

	@Before(value = "encryptSHA256()")
	public void passwordEncrypt(JoinPoint jp) throws Exception {
		MemberVO vo = (MemberVO) (jp.getArgs()[0]);
		String userPwd = new SHA256Util().encryptData(vo.getUserPw());
		vo.setUserPw(userPwd);
	}

	@Pointcut("execution(* org.kh.member.model.service.*ServiceImpl.selectOneMember(..))")
	public void encryptSHA256Login() {
	}

	@Before(value = "encryptSHA256Login()")
	public void passwordEncryptLogin(JoinPoint jp) throws Exception {
		MemberVO vo = (MemberVO) (jp.getArgs()[0]);

		String userPwd = new SHA256Util().encryptData(vo.getUserPw());

		vo.setUserPw(userPwd);
	}

}
