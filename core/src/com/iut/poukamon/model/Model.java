package com.iut.poukamon.model;

import com.iut.poukamon.model.game.Game;
import com.iut.poukamon.model.menu.Menu;

/**
 * @author Chlorodatafile
 */
public class Model {
    private static boolean wait = false;

    // Submodel instance
    private Game game;
    private Menu menu;

    /**
     * Constructor.
     */
    public Model() {
        menu = new Menu(this);
    }

    public static boolean isWaiting() {
        return wait;
    }

    public static void sleep() {
        wait = true;
    }

    public static void awake() {
        wait = false;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Menu getMenu() {
        return menu;
    }
}