package com.ns.neogine.input.events;

import com.ns.neogine.window.Window;

public class InputEventWindowMinimized extends InputEventWindow {
	public final boolean minimized;


	public InputEventWindowMinimized(Window win, boolean min) {
		super(win);
		minimized = min;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.WindowMinimized;
	}

}
