package com.ns.neogine.exception;

public class GameException extends Exception {

	public GameException(String mesg) {
		super(mesg);
	}

	public GameException(String mesg, Exception c) {
		super(mesg, c);
	}

}
