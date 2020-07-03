package dev.asciarrone.fabricktest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadDateException extends RuntimeException {

	public BadDateException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7021262837886591838L;

}
