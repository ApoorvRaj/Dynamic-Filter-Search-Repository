package com.movie.search.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseTO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean error;
	public List<Error> errors;
	public T data;

	public ResponseTO(T result) {

	}
}
