package com.ns.neogine.math;

/**
 * A 3D vector.
 */
public class Vector3f {
	/**
	 * X coordinate.
	 */
	public float x;
	/**
	 * Y coordinate.
	 */
	public float y;
	/**
	 * Z coordinate.
	 */
	public float z;


	public Vector3f() {
		set(0, 0, 0);
	}

	/**
	 * Constructor.
	 *
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @param z Z coordinate.
	 */
	public Vector3f(float x, float y, float z) {
		set(x, y, z);
	}

	/**
	 * Copy constructor.
	 *
	 * @param v Vector to copy.
	 */
	public Vector3f(Vector3f v) {
		set(v.x, v.y, v.z);
	}


	public Vector3f dup() {
		return new Vector3f(this);
	}

	public Vector3f set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	public Vector3f set(Vector3f v) {
		x = v.x;
		y = v.y;
		z = v.z;
		return this;
	}


	public Vector3f add(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3f add(Vector3f v) {
		x += v.x;
		y += v.y;
		z += v.z;
		return this;
	}

	public Vector3f sub(float x, float y, float z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector3f sub(Vector3f v) {
		x -= v.x;
		y -= v.y;
		z -= v.z;
		return this;
	}

	public Vector3f mul(float x, float y, float z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector3f mul(Vector3f v) {
		x *= v.x;
		y *= v.y;
		z *= v.z;
		return this;
	}

	public Vector3f div(float x, float y, float z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector3f div(Vector3f v) {
		x /= v.x;
		y /= v.y;
		z /= v.z;
		return this;
	}
}
