package com.iut.poukamon.model.game;

import com.iut.poukamon.model.Model;

/**
 * @author Chlorodatafile
 */
public class Game {

    byte turn;
    byte playerNumber;

    public Game(int playerNumber) {
        this.turn=0;
        this.playerNumber=(byte)playerNumber;
        beginTurn();
        Model.awake();
    }

    /**
     * Getters
     */
    public int getPlayerNumber() {
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
