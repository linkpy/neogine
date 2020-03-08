package com.ns.neogine.game;

public interface IGame {
    void load(Game game);

    void initialize(Game game);

    void update(Game game, double dt);

    void render(Game game);

    void shutdown(Game game);

    void unload(Game game);
}
