package com.mygdx.fantastickworld;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.fantastickworld.screen.GameSc;

public class Main extends Game {
	public static SpriteBatch batch;
	public static Texture img;
	public static int HEIGHT,WIDTH;
	public static Texture circle, actor;
	public static OrthographicCamera camera;
	public static Texture knight;
	public static Texture place;

	@Override
	public void create () {
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		batch = new SpriteBatch();
		knight = new Texture("knight2.0.png");
		place = new Texture("forest.png");
		circle = new Texture("Circle.png");
		actor = new Texture("Stick.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		setScreen(new GameSc(this));
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
