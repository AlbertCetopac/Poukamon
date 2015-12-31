package com.iut.poukamon.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

/**
 * @author Chlorodatafile
 */
public interface ViewConstant {
    LabelStyle FONT_STYLE = new LabelStyle(new BitmapFont(Gdx.files.internal("Font/Polentical_Neon.fnt")), new Color(0.1f, 0.1f, 0.1f, 1));

    int SCREEN_WIDTH = 1024;
    int SCREEN_HEIGHT = 768;

    float SCREEN_REFERENCE_SIZE = SCREEN_WIDTH<SCREEN_HEIGHT ? SCREEN_WIDTH : SCREEN_HEIGHT;
}
