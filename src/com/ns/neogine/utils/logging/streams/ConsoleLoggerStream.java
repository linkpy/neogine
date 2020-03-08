package com.ns.neogine.utils.logging.streams;

import com.ns.neogine.utils.logging.ILoggerStream;
import com.ns.neogine.utils.logging.LogMessage;

/**
 * Logger stream, writing the log messages to the console.
 */
public class ConsoleLoggerStream implements ILoggerStream {

	/**
	 * Writes the given message into the stream.
	 *
	 * @param msg Message to write.
	 */
	@Override
	public void write(LogMessage msg) {
		String s = String.format("[ % 11.6fs | % 6df ] %s - %s : %s",
			msg.getTime(), msg.getFrame(),
			msg.getEmitterName(), msg.getSeverity().name(),
			msg.getMessage()
		);

		switch( msg.getSeverity() ) {
			case Debug:
			case Verbose:
			case Info:
				System.out.println(s);
				break;
			case Warning:
				System.err.println(s);
				break;
			case Error:
			case Fatal:
				System.err.println(s);

				StackTraceElement[] stes = msg.getStack();

				for( int i = 4; i < stes.length; i++ ) {
					StackTraceElement ste = stes[i];
					System.err.printf("|\t%s:%04d > %s::%s\n",
						ste.getFileName(), ste.getLineNumber(),
						ste.getClassName(), ste.getMethodName()
					);
				}
		}
	}
}
