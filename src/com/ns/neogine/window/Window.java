package com.ns.neogine.window;

import com.ns.neogine.exception.WindowException;
import com.ns.neogine.math.Vector2i;
import com.ns.neogine.memory.Reference;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Class managing the window.
 */
public class Window extends Reference {
	/**
	 * GLFW window ID.
	 */
	private long _window;

	private Vector2i _min_size;
	private Vector2i _max_size;


	/**
	 * Constructor.
	 */
	public Window() {
		_window = 0;
		_min_size = new Vector2i(-1, -1);
		_max_size = new Vector2i(-1, -1);
	}


	/**
	 * Checks if the window is valid.
	 */
	public boolean isValid() {
		return _window != 0L;
	}

	/**
	 * Gets the GLFW window handle.
	 */
	public long getHandle() {
		return _window;
	}


	/**
	 * Opens the window.
	 *
	 * @param title  Title of the window
	 * @param width  Width of the window
	 * @param height Height of the window
	 * @throws WindowException if an error occurs in GLFW.
	 */
	public void open(String title, int width, int height) throws WindowException {
		// resets the window hints, defines the GL context to 4.5 core profile,
		// and disable all deprecated functions.
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 5);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);

		// creates the window
		_window = glfwCreateWindow(width, height, title, 0, 0);
		// if the creation failed
		if( _window == 0 ) {
			glfwTerminate();
			throw new WindowException("Failed to create GLFW window.");
		}
	}

	/**
	 * Closes the window, destroying it in the process.
	 * If the window isn't valid, this function does nothing.
	 */
	public void close() {
		// if the window isn't valid.
		if( !isValid() )
			return;

		// destroys the window and resets the window ID.
		glfwDestroyWindow(_window);
		_window = 0;
	}

	/**
	 * Returns true if the window should close (closed by the user etc).
	 */
	public boolean shouldClose() {
		return glfwWindowShouldClose(_window);
	}


	/**
	 * Makes the window's context to be the current active one.
	 */
	public void makeCurrent() {
		glfwMakeContextCurrent(_window);
	}

	/**
	 * Displays the content of the window.
	 */
	public void display() {
		glfwSwapBuffers(_window);
	}


	/**
	 * Sets the window's size.
	 */
	public void setSize(int width, int height) {
		glfwSetWindowSize(_window, width, height);
	}

	/**
	 * Gets the window's size.
	 */
	public Vector2i getSize() {
		int[] x = {0};
		int[] y = {0};

		glfwGetWindowSize(_window, x, y);

		return new Vector2i(x[0], y[0]);
	}


	/**
	 * Sets the minimum size of the window.
	 */
	public void setMinimumSize(int w, int h) {
		glfwSetWindowSizeLimits(_window, w, h, _max_size.x, _max_size.y);
		_min_size.x = w;
		_min_size.y = h;
	}

	/**
	 * Sets the maximum size of the window.
	 */
	public void setMaximumSize(int w, int h) {
		glfwSetWindowSizeLimits(_window, _min_size.x, _min_size.y, w, h);
		_max_size.x = w;
		_max_size.y = h;
	}

	/**
	 * Gets the minimum size of the window.
	 */
	public Vector2i getMinimumSize() {
		return new Vector2i(_min_size);
	}

	/**
	 * Gets the maximum size of the window.
	 */
	public Vector2i getMaximumSize() {
		return new Vector2i(_max_size);
	}


	/**
	 * Sets the window's aspect ratio.
	 */
	public void setAspectRatio(int w, int h) {
		glfwSetWindowAspectRatio(_window, w, h);
	}


	/**
	 * Minimizes the window.
	 */
	public void minimize() {
		glfwIconifyWindow(_window);
	}

	/**
	 * Restores the window.
	 */
	public void restore() {
		glfwRestoreWindow(_window);
	}

	/**
	 * Maximizes the window.
	 */
	public void maximize() {
		glfwMaximizeWindow(_window);
	}


	/**
	 * Hides the window.
	 */
	public void hide() {
		glfwHideWindow(_window);
	}

	/**
	 * Shows the window.
	 */
	public void show() {
		glfwShowWindow(_window);
	}


	/**
	 * Focuses the window.
	 */
	public void focus() {
		glfwFocusWindow(_window);
	}

	/**
	 * Checks if the window is currently focused.
	 */
	public boolean isFocused() {
		return glfwGetWindowAttrib(_window, GLFW_FOCUSED) == GLFW_TRUE;
	}

	/**
	 * Requests the attention from the user.
	 */
	public void requestAttention() {
		glfwRequestWindowAttention(_window);
	}


	/**
	 * Enables or disables VSync.
	 */
	public void setVSync(boolean enabled) {
		if( enabled )
			glfwSwapInterval(1);
		else
			glfwSwapInterval(0);
	}


	/**
	 * Destroys the object. Implementation.
	 */
	@Override
	protected void _destroy() {
		close();
	}
}
