package com.ns.neogine.utils.logging;

/**
 * Log message.
 */
public class LogMessage {
    /**
     * Time since the start of the game, in nanoseconds.
     */
    private long _time;
    /**
     * Frame at which the message was emitted.
     */
    private long _frame;
    /**
     * Name of the emitter.
     */
    private String _emitter_name;
    /**
     * Severity of the message.
     */
    private LogSeverity _severity;
    /**
     * Content of the message.
     */
    private String _message;

    /**
     * Stack when the message was emitted. Only when severity is Error or Fatal.
     */
    private StackTraceElement[] _stack;


    /**
     * Constructor.
     *
     * @param t Time.
     * @param f Frame.
     * @param n Emitter name.
     * @param s Severity.
     * @param m Message.
     */
    public LogMessage(long t, long f, String n, LogSeverity s, String m) {
        _time = t;
        _frame = f;
        _emitter_name = n;
        _severity = s;
        _message = m;
        _stack = null;

        if( s == LogSeverity.Error || s == LogSeverity.Fatal )
            _stack = Thread.currentThread().getStackTrace();
    }


    /**
     * Gets the time at which the message was emitted.
     */
    public long getTime() {
        return _time;
    }

    /**
     * Gets the frame at which the message was emitted.
     */
    public long getFrame() {
        return _frame;
    }

    /**
     * Gets the emitter name.
     */
    public String getEmitterName() {
        return _emitter_name;
    }

    /**
     * Gets the severity of the message.
     */
    public LogSeverity getSeverity() {
        return _severity;
    }

    /**
     * Gets the message.
     */
    public String getMessage() {
        return _message;
    }

    /**
     * Gets the stack.
     */
    public StackTraceElement[] getStack() {
        return _stack;
    }
}
