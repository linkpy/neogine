package com.ns.neogine.exception;

/**
 * Exception thrown when a resource failed to load.
 */
public class ResourceException extends Exception {
	/**
	 * Constructor.
	 *
	 * @param t Type of the resource (image, shader, etc)
	 * @param p Path to the resource.
	 * @param m Error message.
	 */
	public ResourceException(String t, String p, String m) {
		super(String.format("Exception thrown while loading the %s at %s : %s", t, p, m));
	}

	/**
	 * Constructor.
	 *
	 * @param t Type of the resource (image, shader, etc)
	 * @param p Path to the resource.
	 * @param m Error message.
	 * @param e Cause.
	 */
	public ResourceException(String t, String p, String m, Exception e) {
		super(String.format("Exception thrown while loading the %s at %s : %s", t, p, m), e);
	}
}
