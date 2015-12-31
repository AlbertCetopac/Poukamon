package com.iut.tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Affine2;

/**
 * Created by chlorodatafile on 31/12/15.
 */
public class Surface extends SpriteBatch {
    private final float screenPercent, screenCoef;
    private final int oX, oY;

    public Surface(int oX, int oY, float screenPercent, float screenCoef) {
        super();
        this.oX=oX;
        this.oY=oY;
        this.screenPercent=screenPercent;
        this.screenCoef=screenCoef;
    }

    public void absoluteDraw(Texture texture, float x, float y) {
        super.draw(texture, x, y, texture.getWidth(), texture.getHeight());
    }

    public void unscaledDraw(Texture texture, float percentX, float percentY) {
        super.draw(texture, oX+percentX*screenPercent, oY+percentY*screenPercent, texture.getWidth(), texture.getHeight());
    }

    public void draw(Texture texture) {
        int w = texture.getWidth(), h=texture.getHeight();
        super.draw(texture, oX,oY, 0, 0, w,h,screenCoef,screenCoef,0,0,0,w,h,false,false);
    }

    public void draw(TextureRegion region) {
        int w = region.getRegionWidth(), h=region.getRegionHeight();
        super.draw(region, oX,oY, 0,0,w,h,screenCoef,screenCoef,0);
    }

    @Override
    public void draw(Texture texture, float percentX, float percentY) {
        int w = texture.getWidth(), h=texture.getHeight();
        super.draw(texture, oX+percentX*screenPercent, oY+percentY*screenPercent, 0, 0, w,h,screenCoef,screenCoef,0,0,0,w,h,false,false);
    }

    @Override
    public void draw(TextureRegion region, float percentX, float percentY) {
        int w = region.getRegionWidth(), h=region.getRegionHeight();
        super.draw(region, oX+percentX*screenPercent, oY+percentY*screenPercent, 0,0,w,h,screenCoef,screenCoef,0);
    }

    public void draw(Texture texture, float percentX, float percentY, float scale) {
        int w = texture.getWidth(), h=texture.getHeight();
        super.draw(texture, oX+percentX*screenPercent, oY+percentY*screenPercent, 0, 0, w,h,scale*=screenCoef,scale,0,0,0,w,h,false,false);
    }

    public void draw(TextureRegion region, float percentX, float percentY, float scale) {
        int w = region.getRegionWidth(), h=region.getRegionHeight();
        super.draw(region, oX+percentX*screenPercent, oY+percentY*screenPercent, 0, 0, w,h,scale*=screenCoef,scale,0);
    }

    @Override
    public void draw(Texture texture, float percentX, float percentY, float scale, float rotation) {
        int w = texture.getWidth(), h=texture.getHeight();
        super.draw(texture, oX+percentX*screenPercent, oY+percentY*screenPercent, 0, 0, w,h,scale*=screenCoef,scale,rotation,0,0,w,h,false,false);
    }

    @Override
    public void draw(TextureRegion region, float percentX, float percentY, float scale, float rotation) {
        int w = region.getRegionWidth(), h=region.getRegionHeight();
        super.draw(region, oX+percentX*screenPercent, oY+percentY*screenPercent, 0, 0, w,h,scale*=screenCoef,scale,rotation);
    }

    public void draw(Texture texture, float percentX, float percentY, float scale, boolean flipY) {
        int w = texture.getWidth(), h=texture.getHeight();
        super.draw(texture, oX+percentX*screenPercent, oY+percentY*screenPercent, 0, 0, w,h,scale*=screenCoef,scale,0,0,0,w,h,false,flipY);
    }

    public void draw(TextureRegion region, float percentX, float percentY, float scale, boolean flipY) {
        int w = region.getRegionWidth(), h=region.getRegionHeight();
        super.draw(region, oX+percentX*screenPercent, oY+percentY*screenPercent, 0, 0, w,h,scale*=screenCoef,flipY?-scale:scale,0);
    }

    public void draw(Texture texture, float percentX, float percentY, float scale, float rotation, boolean flipY) {
        int w = texture.getWidth(), h=texture.getHeight();
        super.draw(texture, oX+percentX*screenPercent, oY+percentY*screenPercent, 0, 0, w,h,scale*=screenCoef,scale,rotation,0,0,w,h,false,flipY);
    }

    public void draw(TextureRegion region, float percentX, float percentY, float scale, float rotation, boolean flipY) {
        int w = region.getRegionWidth(), h=region.getRegionHeight();
        super.draw(region, oX+percentX*screenPercent, oY+percentY*screenPercent, 0, 0, w,h,scale*=screenCoef,flipY?-scale:scale,rotation);
    }

}
