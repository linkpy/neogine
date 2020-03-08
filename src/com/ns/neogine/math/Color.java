package com.ns.neogine.math;


public class Color {
	public float r, g, b, a;


	public Color() {
		set(0f, 0f, 0f, 1f);
	}

	public Color(float r, float g, float b) {
		set(r, g, b, 1f);
	}

	public Color(float r, float g, float b, float a) {
		set(r, g, b, a);
	}

	public Color(Color c) {
		set(c);
	}


	public Color set(float r, float g, float b) {
		this.r = Math.clamp_normal(r);
		this.g = Math.clamp_normal(g);
		this.b = Math.clamp_normal(b);
		return this;
	}

	public Color set(float r, float g, float b, float a) {
		this.r = Math.clamp_normal(r);
		this.g = Math.clamp_normal(g);
		this.b = Math.clamp_normal(b);
		this.a = Math.clamp_normal(a);
		return this;
	}

	public Color set(Color c) {
		r = Math.clamp_normal(c.r);
		g = Math.clamp_normal(c.g);
		b = Math.clamp_normal(c.b);
		a = Math.clamp_normal(c.a);
		return this;
	}

	public Color normalize() {
		r = Math.clamp_normal(r);
		g = Math.clamp_normal(g);
		b = Math.clamp_normal(b);
		a = Math.clamp_normal(a);
		return this;
	}


	public Color dup() {
		return new Color(this);
	}


	public Color add(float r, float g, float b, float a) {
		set(
			this.r + r,
			this.g + g,
			this.b + b,
			this.a + a
		);
		return this;
	}

	public Color add(float r, float g, float b) {
		set(
			this.r + r,
			this.g + g,
			this.b + b
		);
		return this;
	}
}
