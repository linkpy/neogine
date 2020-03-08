package com.ns.neogine.input.events;

import com.ns.neogine.window.Window;

public class InputEventFrameBufferResized extends InputEventWindow {
	public final int width;
	public final int height;


	public InputEventFrameBufferResized(Window win, int w, int h) {
		super(win);
		width = w;
		height = h;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.FrameBufferResized;
	}

}
