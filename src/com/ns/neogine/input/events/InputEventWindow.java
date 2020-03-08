package com.ns.neogine.input.events;

import com.ns.neogine.window.Window;

public abstract class InputEventWindow extends InputEvent {
	public final Window window;

	public InputEventWindow(Window w) {
		window = w;
	}
}
