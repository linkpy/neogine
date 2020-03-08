package com.ns.neogine.input.events;

import com.ns.neogine.math.Vector2f;

public class InputEventMouseEntered extends InputEventMouse {
	public final boolean entered;


	public InputEventMouseEntered(Vector2f p, boolean e) {
		super(p);
		entered = e;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.MouseEntered;
	}
}
