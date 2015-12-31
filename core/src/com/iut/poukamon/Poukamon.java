package com.iut.poukamon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.iut.poukamon.controller.ControllerTemplate;
import com.iut.poukamon.controller.Controller;
import com.iut.poukamon.controller.menu.MenuController;
import com.iut.poukamon.model.Model;
import com.iut.poukamon.model.menu.Menu;
import com.iut.poukamon.view.ViewConstant;
import com.iut.poukamon.view.ViewPanel;
import com.iut.poukamon.view.menu.MainMenuPanel;
import com.iut.tools.Surface;

/**
 * @author Chlorodatafile
 */

public class Poukamon extends ApplicationAdapter implements ViewConstant {

    private void init() {
        __setted=true;
        setPanel(new MainMenuPanel());
        model.setActiveModel(new Menu());
        Controller.setControllers(new ControllerTemplate[]{new MenuController()});
    }

    final static float BACKGROUND_RED = 1;
    final static float BACKGROUND_GREEN = 1;
    final static float BACKGROUND_BLUE = 1;

    private static Poukamon main;

    private boolean __setted;
    private int xS, yS;
    private Texture mask;
    private boolean isVertical;

    private Surface surface;
    private ViewPanel panel;
    private Model model;

    private void refreshMask(int width, int height) {
        if (mask!=null)
            mask.dispose();

        xS=yS=0;

        int x, y, mPos;
        if (isVertical) {
            mPos=(xS=x=Math.round((width-height)/2))+height;
            y=height;
        } else {
            x=width;
            mPos=(yS=y=Math.round((height-width)/2))+width;
        }

        Pixmap pixmap = new Pixmap(width,height, Pixmap.Format.RGBA4444);
        pixmap.setColor(0,0,0,1);
        pixmap.fillRectangle(0, 0, x, y);

        if (isVertical)
            pixmap.fillRectangle(mPos,0,x,y);
        else
            pixmap.fillRectangle(0,mPos,x,y);

        mask = new Texture(pixmap);

        pixmap.dispose();
    }

    @Override
    public void create() {

        // On génére le singleton et le model
        main = this;
        model = new Model();

        // On gère les inputs
        Gdx.input.setInputProcessor(new Controller(model, this));

        // On genere l'affichage
        ViewPanel.linkToModel(model, this);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(BACKGROUND_RED, BACKGROUND_GREEN, BACKGROUND_BLUE, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        model.update();
        surface.begin();
        panel.render(surface);
        surface.absoluteDraw(mask, 0, 0);
        surface.end();
    }

    @Override
    public void resize(int width, int height) {

        isVertical=width>=height;

        refreshMask(width, height);

        Gdx.gl.glViewport(0, 0, width, height);

        if (surface!=null)
            surface.dispose();
        if (isVertical)
            surface = new Surface(xS,yS,height/100f,height/SCREEN_REFERENCE_SIZE);
        else
            surface = new Surface(xS,yS,width/100f,width/SCREEN_REFERENCE_SIZE);

        if (!__setted&&model!=null)
            init();
    }

    public ViewPanel getPanel() {
        return panel;
    }

    public static void setPanel(ViewPanel panel) {
        if (main.panel != null)
            main.panel.dispose();
        main.panel = panel;
        panel.start();
    }

    public SpriteBatch getSurface() {
        return surface;
    }
}