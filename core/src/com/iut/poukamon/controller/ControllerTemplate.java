package com.iut.poukamon.controller;

import com.iut.poukamon.Poukamon;
import com.iut.poukamon.model.Model;

/**
 * @author Chlorodatafile
 */
public abstract class ControllerTemplate {

    protected static Model model;
    protected static Poukamon view;

    static void initialise(Model nModel, Poukamon nView) {
        model = nModel;
        view = nView;
    }

    public void keyDown(int keycode) {
    }

    public void keyUp(int keycode) {
    }

    public void keyTyped(char character) {
    }

    public void mousePressed(int x, int y, int pointer, int button) {
    }

    public void mouseReleased(int x, int y, int pointer, int button) {
    }

    public void mouseMoved(int x, int y) {
    }

    public void touchDragged(int x, int y, int pointer) {
    }

    public void touchScrolled(int amount) {
    }
}
