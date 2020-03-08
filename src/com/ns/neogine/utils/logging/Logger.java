package com.ns.neogine.utils.logging;

import com.ns.neogine.game.Game;

import java.util.LinkedList;


/**
 * Logger.
 */
public class Logger {
    /**
     * The game instance.
     */
    private Game _game;
    /**
     * List of all logger streams.
     */
    private LinkedList<ILoggerStream> _streams;
    /**
     * Name of the emitter.
     */
    private String _emitter_name;


    /**
     * Constructor.
     */
    public Logger(Game g) {
        _game = g;
        _streams = new LinkedList<>();
        _emitter_name = "";
    }


    /**
     * Adds a logger stream.
     */
    public void addStream(ILoggerStream ils) {
        _streams.add(ils);
    }


    /**
     * Sets the emitter name. Used by debug, verbose, info, warning and error.
     */
    public void setEmitter(String name) {
        _emitter_name = name;
    }


    /**
     * Logs a debug message.
     */
    public void debug(String m) {
        log(_emitter_name, LogSeverity.Debug, m);
    }

    /**
     * Logs a verbose message.
     */
    public void verbose(String m) {
        log(_emitter_name, LogSeverity.Verbose, m);
    }

    /**
     * Logs an information message.
     */
    public void info(String m) {
        log(_emitter_name, LogSeverity.Info, m);
    }

    /**
     * Logs a warning message.
     */
    public void warning(String m) {
        log(_emitter_name, LogSeverity.Warning, m);
    }

    /**
     * Logs an error message.
     */
    public void error(String m) {
        log(_emitter_name, LogSeverity.Error, m);
    }

    /**
     * Logs a fatal message.
     */
    public void fatal(String m) {
        log(_emitter_name, LogSeverity.Fatal, m);
    }


    /**
     * Logs a formatted debug message.
     */
    public void debugf(String f, Object... obj) {
        log(_emitter_name, LogSeverity.Debug, String.format(f, obj));
    }

    /**
     * Logs a formatted verbose message.
     */
    public void verbosef(String f, Object... obj) {
        log(_emitter_name, LogSeverity.Verbose, String.format(f, obj));
    }

    /**
     * Logs a formatted information message.
     */
    public void infof(String f, Object... obj) {
        log(_emitter_name, LogSeverity.Info, String.format(f, obj));
    }

    /**
     * Logs a formatted warning message.
     */
    public void warningf(String f, Object... obj) {
        log(_emitter_name, LogSeverity.Warning, String.format(f, obj));
    }

    /**
     * Logs a formatted error message.
     */
    public void errorf(String f, Object... obj) {
        log(_emitter_name, LogSeverity.Error, String.format(f, obj));
    }

    /**
     * Logs a formatted fatal message.
     */
    public void fatalf(String f, Object... obj) {
        log(_emitter_name, LogSeverity.Fatal, String.format(f, obj));
    }


    /**
     * Logs a debug message, with a custom emitter name.
     */
    public void debuge(String e, String m) {
        log(e, LogSeverity.Debug, m);
    }

    /**
     * Logs a verbose message, with a custom emitter name.
     */
    public void verbosee(String e, String m) {
        log(e, LogSeverity.Verbose, m);
    }

    /**
     * Logs an information message, with a custom emitter name.
     */
    public void infoe(String e, String m) {
        log(e, LogSeverity.Info, m);
    }

    /**
     * Logs a warning message, with a custom emitter name.
     */
    public void warninge(String e, String m) {
        log(e, LogSeverity.Warning, m);
    }

    /**
     * Logs a error message, with a custom emitter name.
     */
    public void errore(String e, String m) {
        log(e, LogSeverity.Error, m);
    }

    /**
     * Logs a fatal message, with a custom emitter name.
     */
    public void fatale(String e, String m) {
        log(e, LogSeverity.Fatal, m);
    }


    /**
     * Logs a formatted debug message, with a custom emitter name.
     */
    public void debugef(String e, String f, Object... obj) {
        log(e, LogSeverity.Debug, String.format(f, obj));
    }

    /**
     * Logs a formatted verbose message, with a custom emitter name.
     */
    public void verboseef(String e, String f, Object... obj) {
        log(e, LogSeverity.Verbose, String.format(f, obj));
    }

    /**
     * Logs a formatted information message, with a custom emitter name.
     */
    public void infoef(String e, String f, Object... obj) {
        log(e, LogSeverity.Info, String.format(f, obj));
    }

    /**
     * Logs a formatted warning message, with a custom emitter name.
     */
    public void warningef(String e, String f, Object... obj) {
        log(e, LogSeverity.Warning, String.format(f, obj));
    }

    /**
     * Logs a formatted error message, with a custom emitter name.
     */
    public void erroref(String e, String f, Object... obj) {
        log(e, LogSeverity.Error, String.format(f, obj));
    }

    /**
     * Logs a formatted fatal message, with a custom emitter name.
     */
    public void fatalef(String e, String f, Object... obj) {
        log(e, LogSeverity.Fatal, String.format(f, obj));
    }


    /**
     * Logs a message.
     */
    private void log(String n, LogSeverity s, String m) {
        _dispatch(new LogMessage(
            _game.getTime(), _game.getFrame(),
            n, s, m
        ));
    }

    /**
     * Dispatches a message to all registered logger stream.
     */
    private void _dispatch(LogMessage m) {
        for( ILoggerStream ils : _streams )
            ils.write(m);
    }

}
