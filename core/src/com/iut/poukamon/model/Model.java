package com.iut.poukamon.model;

import com.iut.poukamon.model.game.Game;
import com.iut.poukamon.model.menu.Menu;

/**
 * @author Chlorodatafile
 */
public class Model {
    private static boolean wait = false;

    private ModelTemplate activeModel;

    /**
     * Constructor.
     */
    public Model() {
        ModelTemplate.set(this);
    }

    public void update() {
        if (!wait && activeModel!=null)
            activeModel.update();
    }

    public void setActiveModel(ModelTemplate modelTemplate) {
        if (activeModel!=null)
            activeModel.dispose();
        activeModel=modelTemplate;
        modelTemplate.start();
        awake();
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
        return (Game)activeModel;
    }

    public Menu getMenu() {
        return (Menu)activeModel;
    }
}