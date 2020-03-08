package com.ns.neogine.render;

import static org.lwjgl.opengl.GL45.*;

public enum PolygonRenderMode {
	Points(GL_POINTS),
	Lines(GL_LINES),
	LineStrip(GL_LINE_STRIP),
	LineLoop(GL_LINE_LOOP),
	Triangles(GL_TRIANGLES),
	TriangleStrip(GL_TRIANGLE_STRIP),
	TriangleFan(GL_TRIANGLE_FAN);

	public final int code;

	PolygonRenderMode(int c) {
		code = c;
	}
}
