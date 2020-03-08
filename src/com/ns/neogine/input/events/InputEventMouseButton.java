package com.ns.neogine.input.events;

import com.ns.neogine.input.Button;
import com.ns.neogine.input.KeyModifiers;
import com.ns.neogine.math.Vector2f;

public class InputEventMouseButton extends InputEventMouse {
	public final Button button;
	public final boolean pressed;
	public final KeyModifiers modifiers;


	public InputEventMouseButton(Vector2f pos, Button b, boolean p, KeyModifiers m) {
		super(pos);
		button = b;
		pressed = p;
		modifiers = m;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.MouseButton;
	}
}
