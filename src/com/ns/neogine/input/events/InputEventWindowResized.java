package com.ns.neogine.input.events;

import com.ns.neogine.window.Window;


public class InputEventWindowResized extends InputEventWindow {
	public final int width;
	public final int height;


	public InputEventWindowResized(Window win, int w, int h) {
		super(win);
		width = w;
		height = h;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.WindowResized;
	}
}
