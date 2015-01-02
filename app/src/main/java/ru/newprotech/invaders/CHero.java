package ru.newprotech.invaders;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;

/**
 * Created by kinzoxbeato on 28.12.2014.
 */
public class CHero implements IThinker{
    private static CHero ourInstance = new CHero();

    public static CHero getInstance() {
        return ourInstance;
    }

    private CHero() {
        sprite=null;
    }

    private CSprite sprite;

    @Override
    public void Draw(Canvas canvas) {
        if(sprite!=null)
            sprite.Draw(canvas);
    }

    @Override
    public int Think(long delta) {
        CController controller = CController.getInstance();
        if (controller.isMove()){
            PointF point = controller.getMoveHere();
            if (Math.abs(point.x - sprite.getX())>1 || Math.abs(point.y - sprite.getY())>1) {
                float rate = (float) Math.hypot(point.x - sprite.getX(), point.y - sprite.getY());
                sprite.setVx((point.x - sprite.getX()) * .4f/rate);
                sprite.setVy((point.y - sprite.getY()) * .4f/rate);
            }
            else
                sprite.stop();
        }
        else
            sprite.stop();
        sprite.Think(delta);
        return 0;
    }

    public void setSprite(CSprite sprite) {
        this.sprite = sprite;
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }
}