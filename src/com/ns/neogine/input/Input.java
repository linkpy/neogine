package com.ns.neogine.input;

import com.ns.neogine.input.events.*;
import com.ns.neogine.math.Vector2f;
import com.ns.neogine.window.Window;

import java.util.LinkedList;

import static org.lwjgl.glfw.GLFW.*;


public class Input {
	private static final int KEY_COUNT = GLFW_KEY_LAST + 1;
	private static final int BUTTON_COUNT = GLFW_MOUSE_BUTTON_LAST + 1;

	public static final int Released = 0x00;
	public static final int JustPressed = 0x03;
	public static final int Pressed = 0x02;
	public static final int JustReleased = 0x04;


	private Window _window;

	private byte[] _keys;
	private Vector2f _last_mouse_position;
	private byte[] _buttons;

	private LinkedList<InputEvent> _queue;


	public Input(Window w) {
		_window = w;
		_keys = new byte[KEY_COUNT];
		_last_mouse_position = new Vector2f(-1, -1);
		_buttons = new byte[BUTTON_COUNT];
		_queue = new LinkedList<>();

		for( int i = 0; i < KEY_COUNT; i++ )
			_keys[i] = (byte) Released;

		for( int i = 0; i < BUTTON_COUNT; i++ )
			_buttons[i] = (byte) Released;

		_setupCallbacks();
	}


	public void update() {
		for( int i = 0; i < KEY_COUNT; i++ ) {
			if( _keys[i] == JustPressed )
				_keys[i] = Pressed;
			if( _keys[i] == JustReleased )
				_keys[i] = Released;
		}

		for( int i = 0; i < BUTTON_COUNT; i++ ) {
			if( _buttons[i] == JustPressed )
				_buttons[i] = Pressed;
			if( _buttons[i] == JustReleased )
				_buttons[i] = Released;
		}
	}


	public void pushEvent(InputEvent ev) {
		_queue.add(ev);
	}

	public boolean hasEvents() {
		return !_queue.isEmpty();
	}

	public InputEvent popEvent() {
		if( !hasEvents() )
			return null;

		return _queue.pop();
	}


	public void receiveEvent(InputEvent ev) {
		pushEvent(ev);

		switch( ev.kind() ) {
			case Key:
				InputEventKey kev = (InputEventKey) ev;

				if( kev.pressed )
					_keys[kev.key.code] = JustPressed;
				else
					_keys[kev.key.code] = JustReleased;
				break;

			case MouseButton:
				InputEventMouseButton bev = (InputEventMouseButton) ev;

				if( bev.pressed )
					_buttons[bev.button.code] = JustPressed;
				else
					_buttons[bev.button.code] = JustReleased;
				break;

			default:
				break;
		}
	}


	private void _setupCallbacks() {
		long wh = _window.getHandle();

		glfwSetWindowSizeCallback(wh, (long win, int w, int h) -> {
			receiveEvent(new InputEventWindowResized(_window, w, h));
		});

		glfwSetFramebufferSizeCallback(wh, (long win, int w, int h) -> {
			receiveEvent(new InputEventFrameBufferResized(_window, w, h));
		});

		glfwSetWindowRefreshCallback(wh, (long win) -> {
			receiveEvent(new InputEventWindowRefreshed(_window));
		});

		glfwSetWindowFocusCallback(wh, (long win, boolean f) -> {
			receiveEvent(new InputEventWindowFocused(_window, f));
		});

		glfwSetWindowIconifyCallback(wh, (long win, boolean i) -> {
			receiveEvent(new InputEventWindowMinimized(_window, i));
		});

		glfwSetWindowMaximizeCallback(wh, (long win, boolean m) -> {
			receiveEvent(new InputEventWindowMaximized(_window, m));
		});

		glfwSetKeyCallback(wh, (long win, int k, int sc, int a, int m) -> {
			Key _k = Key.getKey(k);
			boolean _p = a == GLFW_PRESS;
			KeyModifiers _m = KeyModifiers.getModifier(m & 0x0F);

			receiveEvent(new InputEventKey(_k, sc, _p, _m));
		});

		glfwSetCharCallback(wh, (long win, int c) -> {
			String s = new String(Character.toChars(c));
			receiveEvent(new InputEventText(s));
		});

		glfwSetCursorPosCallback(wh, (long w, double _x, double _y) -> {
			float x = (float) _x;
			float y = (float) _y;

			if( _last_mouse_position.x == -1 ) {
				_last_mouse_position.set(x, y);
			} else {
				Vector2f d = new Vector2f(x, y).sub(_last_mouse_position);
				_last_mouse_position.set(x, y);
				receiveEvent(new InputEventMouseMotion(new Vector2f(x, y), d));
			}
		});

		glfwSetCursorEnterCallback(wh, (long w, boolean e) -> {
			receiveEvent(new InputEventMouseEntered(_last_mouse_position.dup(), e));
		});

		glfwSetMouseButtonCallback(wh, (long w, int b, int a, int m) -> {
			Button _b = Button.getButton(b);
			boolean _p = a == GLFW_PRESS;
			KeyModifiers _m = KeyModifiers.getModifier(m);
			receiveEvent(new InputEventMouseButton(
				_last_mouse_position.dup(), _b, _p, _m
			));
		});
	}
}
