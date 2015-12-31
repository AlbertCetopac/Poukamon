package com.iut.poukamon.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.iut.poukamon.Poukamon;
import com.iut.poukamon.view.ViewConstant;

public class DesktopLauncher implements ViewConstant {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Poukamon";
		config.useGL30 = false;
		config.width = SCREEN_WIDTH;
		config.height = SCREEN_HEIGHT;
		config.fullscreen = false;
		config.resizable = true;
		config.initialBackgroundColor= Color.GRAY;
		/*config.addIcon("Icons/ico_16.png", Files.FileType.Internal);
		config.addIcon("Icons/ico_32.png", Files.FileType.Internal);
		config.addIcon("Icons/ico_48.png", Files.FileType.Internal);
		config.addIcon("Icons/ico_64.png", Files.FileType.Internal);
		config.addIcon("Icons/ico_128.png", Files.FileType.Internal);*/
		new LwjglApplication(new Poukamon(), config);
	}
}
