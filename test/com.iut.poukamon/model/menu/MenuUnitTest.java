package com.iut.poukamon.model.menu;

import com.iut.poukamon.model.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Chlorodatafile on 17/12/2015.
 */
public class MenuUnitTest {

    Menu menu;
    @Before
    public void beforeTest() {
        menu = new Menu(new Model());
    }

    @Test
    public void testNewGame() {
        menu.newGame();
        Assert.assertNotNull(menu.model.getGame());
    }
}
