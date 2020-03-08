package com.ns.neogine.utils;

import com.ns.neogine.math.Color;
import com.ns.neogine.math.Vector2f;
import com.ns.neogine.math.Vector3f;

public class ArrayUtils {

	public static float[] intertwine(int[] counts, float[]... arrays) {
		int size = accumulatedSize(arrays);
		int[] indexes = new int[arrays.length];
		float[] res = new float[size];

		for( int i = 0; i < size; ) {
			for( int j = 0; j < arrays.length; j++ ) {
				for( int k = 0; k < counts[j]; k++ ) {
					res[i] = arrays[j][indexes[j]];
					indexes[j]++;
					i++;
				}
			}
		}

		return res;
	}

	public static int accumulatedSize(float[][] arrays) {
		int res = 0;

		for( float[] array : arrays ) res += array.length;

		return res;
	}


	public static float[] expend(Vector2f[] v) {
		float[] res = new float[v.length * 2];

		for( int i = 0; i < v.length; i++ ) {
			res[i * 2 + 0] = v[i].x;
			res[i * 2 + 1] = v[i].y;
		}

		return res;
	}

	public static float[] expend(Vector3f[] v) {
		float[] res = new float[v.length * 3];

		for( int i = 0; i < v.length; i++ ) {
			res[i * 3 + 0] = v[i].x;
			res[i * 3 + 1] = v[i].y;
			res[i * 3 + 2] = v[i].z;
		}

		return res;
	}

	public static float[] expend(Color[] v) {
		float[] res = new float[v.length * 4];

		for( int i = 0; i < v.length; i++ ) {
			res[i * 4 + 0] = v[i].r;
			res[i * 4 + 1] = v[i].g;
			res[i * 4 + 2] = v[i].b;
			res[i * 4 + 3] = v[i].a;
		}

		return res;
	}

}
