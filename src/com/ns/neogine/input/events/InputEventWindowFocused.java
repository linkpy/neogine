package com.ns.neogine.input.events;

import com.ns.neogine.window.Window;

public class InputEventWindowFocused extends InputEventWindow {
	public final boolean focused;


	public InputEventWindowFocused(Window w, boolean f) {
		super(w);
		focused = f;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.WindowFocused;
	}

}
