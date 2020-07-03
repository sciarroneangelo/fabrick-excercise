package dev.asciarrone.fabricktest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	public BadRequestException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6145367022082179998L;

}
