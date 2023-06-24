//package com.nishant.bms.exceptions;
//
//import java.time.LocalDate;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@ControllerAdvice
//public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
//	
//	@ExceptionHandler(Exception.class)
//	public final ErrorDetails handleAllException(Exception ex)
//	{
//		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now() , ex.getMessage());
//		return errorDetails;
//	}
//
//}
