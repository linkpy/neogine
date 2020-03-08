package com.ns.neogine.input.events;

public class InputEventText extends InputEvent {
	public final String text;

	public InputEventText(String t) {
		text = t;
	}


	@Override
	public InputEventKind kind() {
		return InputEventKind.Text;
	}
}
