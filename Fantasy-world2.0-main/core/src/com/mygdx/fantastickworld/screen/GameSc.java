package com.mygdx.fantastickworld.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mygdx.fantastickworld.Actor.Bullet;
import com.mygdx.fantastickworld.Actor.Player;
import com.mygdx.fantastickworld.Main;
import com.mygdx.fantastickworld.Tools.BulletGenerator;
import com.mygdx.fantastickworld.Tools.Joystick;
import com.mygdx.fantastickworld.Tools.Joystick2;
import com.mygdx.fantastickworld.Tools.Point2D;

public class GameSc implements Screen {

    public Joystick joystick;
    public Joystick2 joystick2;
    public static Player player;
    public Main main;
    public static com.badlogic.gdx.utils.Array<Bullet> bullets;
    public BulletGenerator bulgen;

    public GameSc(Main main) {
        this.main = main;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Main.HEIGHT - screenY;
                multitouch((int) screenX, (int) screenY, true, pointer);
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY = Main.HEIGHT - screenY;
                multitouch((int) screenX, (int) screenY, false, pointer);
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                screenY = Main.HEIGHT - screenY;
                multitouch((int) screenX, (int) screenY, true, pointer);
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }
        });
        loadActors();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Main.batch.begin();
        drawMap(Main.batch);
        GameRender(Main.batch);
        Main.batch.end();
        Main.camera.update();
        Main.batch.setProjectionMatrix(Main.camera.combined);
        CameraUpdate();
        GameUpdate();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void multitouch(float x, float y, boolean isDownTouch, int pointer) {
        for (int i = 0; i < 10; i++) {
            joystick.update(x, y, isDownTouch, pointer);
            joystick2.update(x,y,isDownTouch,pointer);
        }
    }

    public void loadActors() {
        bullets = new Array<>();
        bulgen = new BulletGenerator();
        player = new Player(Main.knight, new Point2D(Main.WIDTH / 2, Main.HEIGHT / 2), 10, Main.HEIGHT / 20, 20);
        joystick = new Joystick(Main.circle, Main.actor, Main.HEIGHT / 3, player);
        joystick2 = new Joystick2(Main.circle,Main.actor,Main.HEIGHT / 3,player);
    }

    public void GameUpdate() {
        player.setDirection(joystick.getDir());
        player.update();
        bulgen.update(joystick2);
        for (int i = 0; i < bullets.size; i++) {
            bullets.get(i).update();
            if (bullets.get(i).isOut){
                bullets.removeIndex(i);
            }
        }

    }

    public void GameRender(SpriteBatch batch) {
        player.draw(batch);
        joystick.draw(batch, player);
        joystick2.draw2(batch,player);
        for (int i = 0; i < bullets.size; i++) {
            bullets.get(i).draw(batch);
        }
    }

    public void CameraUpdate() {
        Vector3 position = Main.camera.position;
        position.x = player.position.x;
        position.y = player.position.y;
        Main.camera.position.set(position);
        Main.camera.update();
    }

    public void drawMap(SpriteBatch batch){
        batch.draw(Main.place, -3000, 0, 3000, 3000);
        batch.draw(Main.place,  3000, 0, 3000, 3000);
        batch.draw(Main.place, -3000, -3000, 3000, 3000);
        batch.draw(Main.place, 0, -3000, 3000, 3000);
        batch.draw(Main.place, -3000, 3000, 3000, 3000);
        batch.draw(Main.place, 0, 3000, 3000, 3000);
        batch.draw(Main.place, 3000, 3000, 3000, 3000);
        batch.draw(Main.place, 3000, -3000, 3000, 3000);
        batch.draw(Main.place, 0, 0, 3000, 3000);
    }
}