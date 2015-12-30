package com.iut.poukamon.model.menu;

import com.iut.poukamon.model.ButtonState;
import com.iut.poukamon.model.Model;
import com.iut.poukamon.model.game.Game;

/**
 * @author Chlorodatafile
 */

public class Menu {
    Model model;
    ButtonState stateButtonPlay;
    ButtonState stateButtonQuit;

    public Menu(Model model) {
        stateButtonPlay = ButtonState.NONE;
        stateButtonQuit = ButtonState.NONE;
        this.model = model;
    }

    public void newGame() {
        model.setGame(new Game(2));
    }

    public ButtonState getStateButtonPlay() {
        return stateButtonPlay;
    }

    public void setStateButtonPlay(ButtonState state) {
        stateButtonPlay = state;
    }

    public ButtonState getStateButtonQuit() {
        return stateButtonQuit;
    }

    public void setStateButtonQuit(ButtonState state) {
        stateButtonQuit = state;
    }
}


