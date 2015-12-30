package com.iut.poukamon.controller;

import com.badlogic.gdx.InputProcessor;
import com.iut.poukamon.Poukamon;
import com.iut.poukamon.model.Model;

/**
 * @author Chlorodatafile
 */
public class MainController implements InputProcessor {

    private static MainController main;
    private ControllerTemplate[] controllers;

    public MainController(Model nModel, Poukamon nView) {
        main = this;
        ControllerTemplate.initialise(nModel, nView);
        controllers = new ControllerTemplate[0];
    }

    public static void setControllers(ControllerTemplate[] controllers) {
        main.controllers = controllers;
    }

    @Override
    public boolean keyDown(int keycode) {
        for (ControllerTemplate controller : controllers)
            controller.keyDown(keycode);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        for (ControllerTemplate controller : controllers)
            controller.keyUp(keycode);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        for (ControllerTemplate controller : controllers)
            controller.keyTyped(character);
        return true;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        for (ControllerTemplate controller : controllers)
            controller.mousePressed(x, y, pointer, button);
        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        for (ControllerTemplate controller : controllers)
            controller.mouseReleased(x, y, pointer, button);
        return true;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer) {
        for (ControllerTemplate controller : controllers)
            controller.touchDragged(x, y, pointer);
        return true;
    }

    @Override
    public boolean mouseMoved(int x, int y) {
        for (ControllerTemplate controller : controllers)
            controller.mouseMoved(x, y);
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        for (ControllerTemplate controller : controllers)
            controller.touchScrolled(amount);
        return true;
    }
}
