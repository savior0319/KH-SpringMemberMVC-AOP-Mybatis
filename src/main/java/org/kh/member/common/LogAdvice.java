package org.kh.member.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(int org.kh.member.model.service.*ServiceImpl.*(..))")
	public void allPointcut() {
	}

	/*
	 * @Before("allPointcut()") public void printBeforeLog() {
	 * System.out.println("[공통로그] - 비즈니스 로직 수행전 동작"); }
	 */

	@Around("allPointcut()")
	public Object printAroundLog(ProceedingJoinPoint pjp) throws Throwable {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		String now = sdf.format(date);
		System.out.println(now + " [Before] - 비즈니스 로직 실행 전");
		Object returnObj = pjp.proceed();
		System.out.println(now + " [After] - 비즈니스 로직 실행 후");

		Signature sig = pjp.getSignature();
		System.out.println("[호출] - " + sig);
		return returnObj;
	}

	// private String timeNow;

	public LogAdvice() {

	}

	// public void printLog() {
	// timeNow = time();
	// System.out.println(timeNow + " [공통로그 - LogAdvice] : 비즈니스 로직 수행 전 로그");
	// }
	//
	// public void printTransactionLog() {
	// timeNow = time();
	// System.out.println(timeNow + " [트랜잭션 로그 - LogAdvice] : 트랜잭션 처리 로그");
	// }
	//
	// public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
	// timeNow = time();
	// System.out.println(timeNow + " [BEFORE] : 비즈니스 메소드 수행 전 로그");
	// Object returnObj = pjp.proceed();
	// System.out.println(timeNow + " [AFTER] : 비즈니스 메소드 수행 후 로그");
	//
	// System.out.println("───── 기타 정보 ─────");
	// Signature sig = pjp.getSignature();
	//
	// System.out.println(sig.getName());
	//
	// return returnObj;
	// }
	//
	// public String time() {
	// long time = System.currentTimeMillis();
	// SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
	// timeNow = dayTime.format(new Date(time));
	// return timeNow;
	// }
}
