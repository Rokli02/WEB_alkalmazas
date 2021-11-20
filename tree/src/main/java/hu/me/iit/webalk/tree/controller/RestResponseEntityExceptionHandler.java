package hu.me.iit.webalk.tree.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import hu.me.iit.webalk.tree.service.exceptions.CanNotUpdateNotExistingElementException;
import hu.me.iit.webalk.tree.service.exceptions.NoSuchTreeWithThatIdException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {NoSuchTreeWithThatIdException.class, CanNotUpdateNotExistingElementException.class})
	protected ResponseEntity<Object> handleNoSuchId(RuntimeException ex, WebRequest request) {
		
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		
	}
}
