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
     * Constructor.
     */
    public Logger(Game g) {
        _game = g;
        _streams = new LinkedList<>();
    }


    private void _dispatch(LogMessage m) {
        for( ILoggerStream ils : _streams )
            ils.write(m);
    }

}
