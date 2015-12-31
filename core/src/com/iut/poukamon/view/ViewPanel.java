package com.iut.poukamon.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.iut.poukamon.Poukamon;
import com.iut.poukamon.model.Model;
import com.iut.tools.Surface;

/**
 * @author Chlorodatafile
 */
public abstract class ViewPanel implements ViewConstant {

    public static Model model;
    public static Poukamon window;

    public static void linkToModel(Model nModel, Poukamon poukamon) {
        /* Define the textures */

        /* Assign the model */
        model = nModel;
        window = poukamon;
    }

    public abstract void sendOrder(char code, char act);

    public abstract void start();

    public abstract void dispose();

    public abstract void render(Surface surface);

    protected abstract void refresh(SpriteBatch surface);

    public final void repaint() {
        refresh(window.getSurface());
    }
}
