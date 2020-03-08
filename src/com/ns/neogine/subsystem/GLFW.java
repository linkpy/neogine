package com.ns.neogine.subsystem;

import com.ns.neogine.exception.GLFWException;
import com.ns.neogine.memory.Reference;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwTerminate;

/**
 * GLFW subsystem.
 */
public class GLFW extends Reference {
	/**
	 * Constructor.
	 *
	 * @throws GLFWException if the initialization of GLFW fails.
	 */
	public GLFW() throws GLFWException {
		super();

		if( !glfwInit() ) {
			invalidate();
			throw new GLFWException("Failed to initialize GLFW.");
		}
	}

	/**
	 * Destroys the object.
	 */
	@Override
	protected void _destroy() {
		glfwTerminate();
	}
}
