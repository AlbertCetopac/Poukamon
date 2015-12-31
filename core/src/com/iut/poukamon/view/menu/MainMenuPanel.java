package com.iut.poukamon.view.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.iut.poukamon.view.ViewPanel;
import com.iut.tools.Surface;

/**
 * @author Chlorodatafile
 */
public class MainMenuPanel extends ViewPanel implements MenuConstant {

    Texture combat;

    @Override
    public void sendOrder(char code, char act) {

    }

    @Override
    public void start() {
        combat=new Texture(Gdx.files.internal("img/combat.png"));
    }

    @Override
    public void render(Surface surface) {
        surface.draw(combat);
    }

    @Override
    public void refresh(SpriteBatch surface) {

    }

    @Override
    public void dispose() {

    }
}
