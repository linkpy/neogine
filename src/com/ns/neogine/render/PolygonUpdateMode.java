package com.ns.neogine.render;

import static org.lwjgl.opengl.GL45.*;

public enum PolygonUpdateMode {
	StaticDraw(GL_STATIC_DRAW),
	StaticRead(GL_STATIC_READ),
	StaticCopy(GL_STATIC_COPY),
	StreamDraw(GL_STREAM_DRAW),
	StreamRead(GL_STREAM_READ),
	StreamCopy(GL_STREAM_COPY),
	DynamicDraw(GL_DYNAMIC_DRAW),
	DynamicRead(GL_DYNAMIC_READ),
	DynamicCopy(GL_DYNAMIC_COPY);

	public final int code;

	PolygonUpdateMode(int c) {
		code = c;
	}
}
