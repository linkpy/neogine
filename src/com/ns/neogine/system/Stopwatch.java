package com.ns.neogine.system;

/**
 * Simple stopwatch, using a high resolution timer to keep track of the time
 * elapsed after its creation.
 */
public class Stopwatch {
	/**
	 * Value of the timer when the stopwatch was created.
	 */
	private long _start_time;


	/**
	 * Constructor.
	 */
	public Stopwatch() {
		_start_time = System.nanoTime();
	}


	/**
	 * Gets the elapsed time since the stopwatch was created, in nanoseconds.
	 */
	public long getElapsedTimeNano() {
		return System.nanoTime() - _start_time;
	}

	/**
	 * Gets the elapsed time since the stopwatch was created, in seconds.
	 */
	public float getElapsedTime() {
		return ((float) getElapsedTimeNano()) / 1000000000f;
	}

	/**
	 * Gets the elapsed time since the stopwatch was created, in seconds.
	 * Same as getElapsedTime, but uses a 64bits float.
	 */
	public double getElapsedTimePrecise() {
		return ((double) getElapsedTimeNano()) / 1000000000.0;
	}
}
