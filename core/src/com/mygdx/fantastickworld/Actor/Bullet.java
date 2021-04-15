package com.mygdx.fantastickworld.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.fantastickworld.Tools.Point2D;

public class Bullet extends  Actor {

    public Bullet(Texture img, Point2D position, float speed, float R,Point2D direction) {
        super(img, position, speed, R);
        this.direction = direction;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img,position.getX() - R,position.getY() - R,R * 2, R * 2);
    }

    @Override
    public void update() {
        position.setPoint(direction.getX() * speed, direction.getY() * speed);
        bounds.pos.setPoint(position);
    }
}
