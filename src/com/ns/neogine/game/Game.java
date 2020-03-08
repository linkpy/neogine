package com.ns.neogine.game;

import com.ns.neogine.exception.GameException;
import com.ns.neogine.memory.Cleaner;
import com.ns.neogine.subsystem.GLFW;
import com.ns.neogine.window.Window;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.opengl.GL45.glViewport;


/**
 * Base class for all games.
 */
public class Game {

    private Cleaner _cleaner;
    private Window _window;
    private IGame _main_loop;


    public Game(IGame ml) {
        _cleaner = new Cleaner();
        _main_loop = ml;

        _window = null;
    }


    public void run() throws GameException {
        try {
            _initializeSubsystems();
            _initializeWindow();
            _initializeContext();

            _main_loop.load(this);
            _main_loop.initialize(this);

            while( !_window.shouldClose() ) {
                glfwPollEvents();

                _main_loop.update(this, 0);
                _main_loop.render(this);

                _window.display();
            }

            _main_loop.shutdown(this);
            _main_loop.unload(this);
        } catch( GameException e ) {
            throw e;
        } catch( Exception e ) {
            throw new GameException("Unhandled exception occurred.", e);
        } finally {
            _cleaner.clean();
        }
    }


    private void _initializeSubsystems() throws GameException {
        try {
            _cleaner.add(new GLFW());
        } catch( Exception e ) {
            throw new GameException("Failed to initialize the subsystems.", e);
        }
    }

    private void _initializeWindow() throws GameException {
        try {
            _window = _cleaner.add(new Window());

            _window.open("test", 1280, 768);
        } catch( Exception e ) {
            throw new GameException("Failed to initialize the window.", e);
        }
    }

    private void _initializeContext() {
        _window.makeCurrent();
        GL.createCapabilities();

        glViewport(0, 0, 1280, 768);
    }
}
