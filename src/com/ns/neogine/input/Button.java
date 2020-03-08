package com.ns.neogine.input;

public enum Button {
	Unknown(-1),
	Left(0),
	Right(1),
	Middle(2),
	B4(3),
	B5(4),
	B6(5),
	B7(6),
	B8(7);

	public final int code;

	Button(int c) {
		code = c;
	}


	public static Button getButton(int but) {
		for( Button b : values() ) {
			if( b.code == but )
				return b;
		}

		return Unknown;
	}
}
