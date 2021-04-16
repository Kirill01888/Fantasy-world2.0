package com.mygdx.fantastickworld.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.fantastickworld.Main;
import com.mygdx.fantastickworld.Tools.Point2D;

public class Bullet extends  Actor {


    public boolean isOut;

    public Bullet(Texture img, Point2D position, float speed, float R,Point2D direction) {
        super(img, position, speed, R);
        this.direction = new Point2D(direction);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img,position.getX() - R,position.getY() - R,R * 2, R * 2);
    }

    @Override
    public void update() {
        isOut = ((position.getX() - R > Main.WIDTH || position.getX() + R < 0) || (position.getY() - R > Main.HEIGHT) || (position.getY() + R < 0)) ? true:false;
        position.add(direction.getX() * speed, direction.getY() * speed);
        bounds.pos.setPoint(position);
    }


}
