package com.ns.neogine.input.events;

import com.ns.neogine.math.Vector2f;

public class InputEventMouseMotion extends InputEventMouse {
	public final Vector2f delta;


	public InputEventMouseMotion(Vector2f p, Vector2f d) {
		super(p);
		delta = d;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.MouseMotion;
	}
}
