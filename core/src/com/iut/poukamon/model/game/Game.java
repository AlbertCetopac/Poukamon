package com.iut.poukamon.model.game;

import com.iut.poukamon.model.Model;
import com.iut.poukamon.model.ModelTemplate;

/**
 * @author Chlorodatafile
 */
public class Game extends ModelTemplate {

    byte turn;
    byte playerNumber;

    public Game(int nPlayer) {
        this.playerNumber=(byte)nPlayer;
        this.turn=0;
        beginTurn();
    }

    /**
     * Getters
     */
    public byte getPlayerNumber() {
        return playerNumber;
    }

    public byte getTurn() {
        return turn;
    }

    public void incrementTurn() {
        turn++;
        if (turn == playerNumber)
            turn = 0;
        beginTurn();
    }

    public void beginTurn() {

    }
}
