package com.restweb.retailhub.exception;

public class DataConflictException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataConflictException(String mex) {
		super(mex);
	}
}
