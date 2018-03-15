package member.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
	@ExceptionHandler(Throwable.class)//設定欲處理的例外類別
	public void exceptionHandlerExample1(Throwable t) {
		System.out.println("exceptionHandlerExample1 : " + t.getClass().getSimpleName());
	}
}
