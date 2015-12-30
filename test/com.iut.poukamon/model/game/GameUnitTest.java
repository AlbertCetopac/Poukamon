package com.iut.poukamon.model.game;

import com.badlogic.gdx.audio.Sound;
import com.iut.poukamon.model.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Game unit test
 *
 * @author Aredhele, Xarkes, Coqui, Lyter, Chlorodatafile
 * @version 1.0
 */
public class GameUnitTest {

    private Game game;

    @Before
    public void beforeTest() {
        game = new Game(2);
        //game.walls = Mockito.mock(Sound.class); Exemple de comment eviter un bug avec les import de gdx
    }

    @Test
    public void testModelAwakeWhenStart() {
        Assert.assertFalse(Model.isWaiting());
    }

    @Test
    public void testIncrementTurn() {
        Assert.assertEquals(0, game.getTurn());
        game.incrementTurn();
        Assert.assertEquals(1, game.getTurn());
        game.incrementTurn();
        Assert.assertEquals(0, game.getTurn());
    }

    @Test
    public void testBeginTurn() {

    }

    @Test
    public void testActualPlayer() {

    }
}
