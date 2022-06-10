package com.qa.starterproject.Library.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book not found")
public class BookException extends Exception {
		private static final long serialVersionUID = 3322179265522207925L;

}
