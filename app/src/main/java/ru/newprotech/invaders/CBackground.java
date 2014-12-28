package ru.newprotech.invaders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Created by 6003 on 27.12.2014.
 */
public class CBackground implements IThinker {
    private Bitmap image;
    private float deltaY;
    private float screenY = 0;

    private static CBackground Instance = new CBackground();

    public static CBackground getInstance() {
        return Instance;
    }
    
    public void LoadBackground(int res,int x, int y){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outHeight = y;
        options.outWidth = x;
        GameContext context = GameContext.getInstance();
        image = BitmapFactory.decodeResource(context.getResources(),res,options);
    }

    @Override
    public void Draw(Canvas canvas) {
        screenY = canvas.getHeight();
        RectF screenRect = new RectF(canvas.getClipBounds());
        screenRect.offset(0,deltaY);
        canvas.drawBitmap(image, null, screenRect, null);
        screenRect.offset(0, -screenRect.height());
        canvas.drawBitmap(image, null, screenRect, null);
    }

    @Override
    public int Think(long delta) {
        deltaY+=.1*delta;
        if (deltaY>screenY)
            deltaY = 0;
        return 0;
    }
}
