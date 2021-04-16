package com.mygdx.fantastickworld.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.fantastickworld.Main;
import com.mygdx.fantastickworld.Tools.Point2D;

public class Player extends Actor {

    private int score;
    private float health;

    public Player(Texture img, Point2D position, float speed, float R, float health) {
        super(img, position, speed, R);
        this.health = health;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, position.getX()-R,position.getY()-R, 200,200);
    }

    @Override
    public void update() {
        if (position.getX() + R > 3000) position.setX(3000 - R);
        if (position.getX() - R < 0) position.setX(R);
        if (position.getY() + R > 3000) position.setY(3000 - R);
        if (position.getY() - R < 0) position.setY(R);
        position.add(direction.getX() * speed, direction.getY() * speed);
    }
}
