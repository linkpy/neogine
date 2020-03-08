package com.ns.neogine.input.events;

import com.ns.neogine.window.Window;

public class InputEventWindowMaximized extends InputEventWindow {
	public final boolean maximized;


	public InputEventWindowMaximized(Window w, boolean m) {
		super(w);
		maximized = m;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.WindowMaximized;
	}
}
