package com.ns.neogine.exception;

public class WindowException extends Exception {

	public WindowException(String message) {
		super(message);
	}

	public WindowException(String m, Exception c) {
		super(m, c);
	}
}
