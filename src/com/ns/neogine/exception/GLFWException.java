package com.ns.neogine.exception;

import org.lwjgl.PointerBuffer;

import static org.lwjgl.glfw.GLFW.GLFW_NO_ERROR;
import static org.lwjgl.glfw.GLFW.glfwGetError;

public class GLFWException extends Exception {
	public GLFWException(String m, Exception c) {
		super(m + "\nGLFW Message : " + getGlfwError(), c);
	}

	public GLFWException(String m) {
		super(m + "\nGLFW Message : " + getGlfwError());
	}


	public static String getGlfwError() {
		PointerBuffer buf = PointerBuffer.allocateDirect(1);

		if( glfwGetError(buf) == GLFW_NO_ERROR )
			return "";

		return buf.getStringUTF8(0);
	}
}
