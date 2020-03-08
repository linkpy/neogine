package com.ns.neogine.input;


public enum KeyModifiers {
	None(0x00),
	Shift(0x01),
	Control(0x02),
	Alt(0x04),
	Super(0x08),

	ShiftCtrl(0x03),
	ShiftAlt(0x05),
	ShiftSuper(0x09),
	CtrlAlt(0x06),
	CtrlSuper(0x0A),
	AltSuper(0x0C),

	ShiftCtrlAlt(0x07),
	ShiftCtrlSuper(0x0B),
	CtrlAltSuper(0x0E);


	public final int code;


	KeyModifiers(int c) {
		code = c;
	}


	public boolean hasShift() {
		return (code & Shift.code) != 0;
	}

	public boolean hasControl() {
		return (code & Control.code) != 0;
	}

	public boolean hasAlt() {
		return (code & Alt.code) != 0;
	}

	public boolean hasSuper() {
		return (code & Super.code) != 0;
	}


	public static KeyModifiers getModifier(int mod) {
		for( KeyModifiers k : values() ) {
			if( k.code == mod )
				return k;
		}

		return None;
	}
}
