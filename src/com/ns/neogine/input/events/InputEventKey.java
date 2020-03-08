package com.ns.neogine.input.events;

import com.ns.neogine.input.Key;
import com.ns.neogine.input.KeyModifiers;

public class InputEventKey extends InputEvent {
	public final Key key;
	public final int code;
	public final boolean pressed;
	public final KeyModifiers modifiers;


	public InputEventKey(Key k, int c, boolean p, KeyModifiers m) {
		key = k;
		code = c;
		pressed = p;
		modifiers = m;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.Key;
	}
}
