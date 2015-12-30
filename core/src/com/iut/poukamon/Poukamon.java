package com.iut.poukamon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.iut.poukamon.controller.ControllerTemplate;
import com.iut.poukamon.controller.Controller;
import com.iut.poukamon.controller.menu.MenuController;
import com.iut.poukamon.model.Model;
import com.iut.poukamon.model.menu.Menu;
import com.iut.poukamon.view.ViewPanel;
import com.iut.poukamon.view.menu.MainMenuPanel;

/**
 * @author Chlorodatafile
 */

public class Poukamon extends ApplicationAdapter {
    final static float BACKGROUND_RED = 1;
    final static float BACKGROUND_GREEN = 1;
    final static float BACKGROUND_BLUE = 1;

    private static Poukamon main;

    SpriteBatch surface;
    ViewPanel panel;
    Model model;
    Texture background;

    @Override
    public void create() {

        // On génére le singleton et le model
        main = this;
        model = new Model();

        // On gère les inputs
        Gdx.input.setInputProcessor(new Controller(model, this));

        // On genere l'affichage
        surface = new SpriteBatch();
        background = new Texture(Gdx.files.internal("badlogic.jpg"));
        ViewPanel.linkToModel(model, this);

        // On lance le panel du menu et on active ses controllers
        setPanel(new MainMenuPanel());
        model.setActiveModel(new Menu());
        Controller.setControllers(new ControllerTemplate[]{new MenuController()});
        
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(BACKGROUND_RED, BACKGROUND_GREEN, BACKGROUND_BLUE, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        model.update();
        surface.begin();
        surface.draw(background, 0, 0);
        panel.render(surface);
        surface.end();
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