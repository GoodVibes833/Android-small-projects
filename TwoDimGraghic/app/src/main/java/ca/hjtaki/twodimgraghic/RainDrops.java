package ca.hjtaki.twodimgraghic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RainDrops extends View{
    private float dropX = 0;
    private float dropY = 10;
    private static float radius = 10;
    private float velocityY = 10;
    private int tick = 0;
    private List<RainDrop> drops = new ArrayList<>();


    public RainDrops(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();

        tick++;
        // add drop to the ArrayList
        if (tick % 25 ==0) {
            Random rand = new Random();
            dropX = rand.nextInt(width);
            RainDrop drop = new RainDrop(dropX, 0, radius);
            drops.add(drop);
            System.out.println("size : " + drops.size());
        }

        // draw everything in the drops
        for(RainDrop rainDrop : drops) {
            rainDrop.setDropY(rainDrop.getDropY() + 10);
            canvas.drawCircle(rainDrop.getDropX(), rainDrop.getDropY(), radius, rainDrop.getPaint());
        }

}}
