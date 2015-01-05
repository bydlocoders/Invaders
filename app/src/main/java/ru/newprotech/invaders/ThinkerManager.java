package ru.newprotech.invaders;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.SparseArray;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by kinzoxbeato on 28.12.2014.
 */
public class ThinkerManager implements IThinker{

    Vector<IThinker> collection;
    @Override
    public void Draw(Canvas canvas) {
        for (IThinker i:collection) {
            if (i!=null)
                i.Draw(canvas);
        }
    }

    @Override
    public int Think(long delta) {
        Vector<IThinker> deletable = new Vector<>();
        for (IThinker i:collection) {
            if (i!=null)
                if(i.Think(delta)==IThinker.THINKER_DEAD)
                    deletable.add(i);
        }
        collection.removeAll(deletable);
        return 0;
    }

    public RectF getRectF() {
        return null;
    }

    ThinkerManager(){
        collection = new Vector<>();
    }
}
