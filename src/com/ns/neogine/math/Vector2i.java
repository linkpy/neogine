package com.ns.neogine.math;

public class Vector2i {
	public int x;
	public int y;


	public Vector2i() {
		set(0, 0);
	}

	public Vector2i(int x, int y) {
		set(x, y);
	}

	public Vector2i(Vector2i v) {
		set(v);
	}


	public Vector2i dup() {
		return new Vector2i(this);
	}

	public Vector2i set(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public Vector2i set(Vector2i v) {
		x = v.x;
		y = v.y;
		return this;
	}


	public Vector2i add(int x, int y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2i add(Vector2i v) {
		x += v.x;
		y += v.y;
		return this;
	}

	public Vector2i sub(int x, int y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2i sub(Vector2i v) {
		x -= v.x;
		y -= v.y;
		return this;
	}

	public Vector2i mul(int x, int y) {
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2i mul(Vector2i v) {
		x *= v.x;
		y *= v.y;
		return this;
	}

	public Vector2i div(int x, int y) {
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector2i div(Vector2i v) {
		x /= v.x;
		y /= v.y;
		return this;
	}
}
