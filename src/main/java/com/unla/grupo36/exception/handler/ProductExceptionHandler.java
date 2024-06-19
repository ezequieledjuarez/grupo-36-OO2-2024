package com.unla.grupo36.exception.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.unla.grupo36.dtos.BodyResponseError;
import com.unla.grupo36.exceptions.ProductNotFoundException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ProductExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	protected ResponseEntity<BodyResponseError> responseProductNotFound(ProductNotFoundException ex) {
		return new ResponseEntity<>(new BodyResponseError(404, ex.getMessage()), HttpStatus.NOT_FOUND);
	}
}
