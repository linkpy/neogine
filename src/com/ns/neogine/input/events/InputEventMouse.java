package com.ns.neogine.input.events;

import com.ns.neogine.math.Vector2f;


public abstract class InputEventMouse extends InputEvent {
	public final Vector2f position;

	public InputEventMouse(Vector2f p) {
		position = p;
	}
}
