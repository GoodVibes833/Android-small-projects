package ca.hjtaki.twodimgraghic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TargetView extends View{
    public TargetView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //exercise 2
        Paint red = new Paint();
        red.setARGB(255,255,0,0);

        Paint white = new Paint();
        white.setARGB(255,255,255,255);


        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int numOfCircle = 5;

        // 1 2 3 4 5
        for (int i = 0; i < numOfCircle; i++){
                canvas.drawCircle(width/2,height/2,(width/2)-(70*i), i %2 == 0 ? red : white);

        }

    }


}
