package com.ns.neogine.math;


/**
 * 2D vector using float coordinates.
 */
public class Vector2f {
	public float x;
	public float y;


	public Vector2f() {
		set(0, 0);
	}

	public Vector2f(float x, float y) {
		set(x, y);
	}

	public Vector2f(Vector2f v) {
		set(v);
	}


	public Vector2f dup() {
		return new Vector2f(this);
	}

	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public Vector2f set(Vector2f v) {
		x = v.x;
		y = v.y;
		return this;
	}


	public Vector2f add(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2f add(Vector2f v) {
		x += v.x;
		y += v.y;
		return this;
	}

	public Vector2f sub(float x, float y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2f sub(Vector2f v) {
		x -= v.x;
		y -= v.y;
		return this;
	}

	public Vector2f mul(float x, float y) {
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2f mul(Vector2f v) {
		x *= v.x;
		y *= v.y;
		return this;
	}

	public Vector2f div(float x, float y) {
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector2f div(Vector2f v) {
		x /= v.x;
		y /= v.y;
		return this;
	}
}
