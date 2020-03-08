package com.ns.neogine.utils.logging;

/**
 * Interface for all log message writers.
 */
public interface ILoggerStream {
	/**
	 * Writes the given message into the stream.
	 *
	 * @param msg Message to write.
	 */
	void write(LogMessage msg);
}
