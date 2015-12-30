package com.iut.poukamon.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test of the poukamon.model.Model
 *
 * @author Chlorodatafile
 * @version 1.0
 */
public class ModelUnitTest {

    @Test
    public void testCreation() {
        Model model = new Model();
        Assert.assertNotNull(model.getMenu());
        Assert.assertNull(model.getGame());
    }

    @Test
    public void testSleeping() {
        Assert.assertFalse(Model.isWaiting());
        Model.sleep();
        Assert.assertTrue(Model.isWaiting());
        Model.awake();
        Assert.assertFalse(Model.isWaiting());
    }
}
