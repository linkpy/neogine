package com.ns.neogine.render;

public enum PolygonDataMode {
	Array(0x00),
	ArrayColor(0x01),
	ArrayTexture(0x02),
	ArrayIndex(0x04),

	ArrayColorTexture(0x03),
	ArrayColorIndex(0x05),

	ArrayColorTextureIndex(0x07);


	public final int code;

	PolygonDataMode(int c) {
		code = c;
	}


	public boolean hasColors() {
		return (code & ArrayColor.code) != 0;
	}

	public boolean hasTextures() {
		return (code & ArrayTexture.code) != 0;
	}

	public boolean hasIndexes() {
		return (code & ArrayIndex.code) != 0;
	}
}
