package com.mygdx.fantastickworld.Tools;

import com.mygdx.fantastickworld.Actor.Bullet;
import com.mygdx.fantastickworld.Main;
import com.mygdx.fantastickworld.screen.GameSc;

public class BulletGenerator {
    boolean isFire;

    public  void  update(Joystick2 joy){
        isFire = (joy.getDir().getX() == 0 && joy.getDir().getY() == 0)?false:true;

        if (isFire) GameSc.bullets.add(new Bullet(Main.bullet,GameSc.player.position,25,GameSc.player.R,joy.getDir()));
    }
}
