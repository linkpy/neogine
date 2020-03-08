package com.ns.neogine.input.events;

import com.ns.neogine.window.Window;

public class InputEventWindowRefreshed extends InputEventWindow {

	public InputEventWindowRefreshed(Window w) {
		super(w);
	}

	@Override
	public InputEventKind kind() {
		return InputEventKind.WindowRefreshed;
	}
}
