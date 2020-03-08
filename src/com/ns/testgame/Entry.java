package com.ns.testgame;

import com.ns.neogine.exception.GameException;
import com.ns.neogine.game.Game;

public class Entry {
	public static void main(String[] args) {
		Game g = new Game(new Main());

		try {
			g.run();
		} catch( GameException e ) {
			System.err.println("Unhandled exception :");
			System.err.println(e.toString());
			e.printStackTrace(System.err);
		}
	}
}
