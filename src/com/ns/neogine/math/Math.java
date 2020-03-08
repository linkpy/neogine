package com.ns.neogine.math;

public class Math {

	public static float max(float a, float b) {
		if( a < b )
			return b;
		else
			return a;
	}

	public static float maxv(float... values) {
		float m = Float.NEGATIVE_INFINITY;

		for( float v : values ) {
			if( v > m )
				m = v;
		}

		return m;
	}

	public static float min(float a, float b) {
		if( a < b )
			return a;
		else
			return b;
	}

	public static float minv(float... values) {
		float m = Float.POSITIVE_INFINITY;

		for( float v : values ) {
			if( v < m )
				m = v;
		}

		return m;
	}


	public static float clamp(float v, float min, float max) {
		if( v < min )
			return min;
		if( v > max )
			return max;
		return v;
	}

	public static float clamp_normal(float v) {
		return clamp(v, 0f, 1f);
	}


	public static float wrap(float v, float min, float max) {
		float l = max - min;

		while( v > max )
			v -= l;
		while( v < min )
			v += l;

		return v;
	}

	public static float wrap_normal(float v) {
		return wrap(v, 0f, 1f);
	}
}
