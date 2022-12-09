//package com.testyantra.sastaapp.advice;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//@Aspect
//@Component
//public class LoggingAdvice {
//	Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);
//
//	@Pointcut(value = "execution(* com.testyantra.sastaapp.*.*.*(..))")
//	public void myPointCut() {
// }
//	@Around("myPointCut()")
//	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//		ObjectMapper mapper = new ObjectMapper();
//		String methodName = pjp.getSignature().getName();
//		String className = pjp.getTarget().getClass().toString();
//		Object[] array = pjp.getArgs();
//		// Before method invoke
//		logger.info("Method Invoked" + className + " :" + methodName + " ()" + "arguments :"
//				+ mapper.writeValueAsString(array));
//		Object proceed = pjp.proceed();
//		// After method invoke
//		logger.info(className + " :" + methodName + " ()" + "Response :" + mapper.writeValueAsString(proceed));
//		return proceed;
//	}
//}
