package com.ns.neogine.exception;

public class RenderException extends Exception {

	public RenderException(String message) {
		super(message);
	}

	public RenderException(String m, Exception c) {
		super(m, c);
	}
}
